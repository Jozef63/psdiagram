/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.miroslavbartyzal.psdiagram.app.parser.antlr;

import cz.miroslavbartyzal.psdiagram.app.parser.PSDGrammarParser;
import cz.miroslavbartyzal.psdiagram.app.parser.PSDGrammarParserBaseVisitor;
import java.util.ArrayList;
import java.util.List;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 *
 * @author Miroslav Bartyzal (miroslavbartyzal@gmail.com)
 */
public class PSDToJavaScriptVisitor extends PSDGrammarParserBaseVisitor<String>
{

    private final String input;

    public PSDToJavaScriptVisitor(String input)
    {
        this.input = input;
    }

    @Override
    public String visitMultiplicative_Expression(PSDGrammarParser.Multiplicative_ExpressionContext ctx)
    {
        for (ParseTree child : ctx.children) {
            if (!(child instanceof PSDGrammarParser.Multiplicative_Expression_OperatorContext)
                    && !(child instanceof PSDGrammarParser.Multiplicative_Expression_LeftPartContext)
                    && !(child instanceof PSDGrammarParser.Multiplicative_Expression_RightPartContext)) {
                throw new IllegalStateException("Unexpected RuleNode!");
            }
        }

        String result = ctx.multiplicative_Expression_LeftPart().accept(this);

        List<PSDGrammarParser.Multiplicative_Expression_OperatorContext> operators = new ArrayList<>(
                ctx.multiplicative_Expression_Operator());
        List<ParserRuleContext> rightSideOperands = new ArrayList<>(ctx.multiplicative_Expression_RightPart());

        for (int i = 0; i < operators.size(); i++) {
            PSDGrammarParser.Multiplicative_Expression_OperatorContext operator = operators.get(i);
            if (operator.operator.getType() == PSDGrammarParser.FLOORDIV) {
                result = transformToMathFloor(result, operator.accept(this), rightSideOperands.get(i).accept(this));
            } else {
                result += operator.accept(this) + rightSideOperands.get(i).accept(this);
            }
        }

        return result;
    }

    private String transformToMathFloor(String leftOperand, String operator, String rightOperand)
    {
        String[] leftOperandLSplit = splitSpaceLeft(leftOperand);
        String[] operatorRSplit = splitSpaceRight(operator);
        String[] rightOperandRSplit = splitSpaceRight(rightOperand);

        return leftOperandLSplit[0] // muze byt neprazdna jen na zacatku inputu, protoze terminal sbira mezery jen vpravo
                + "Math.floor(" + leftOperandLSplit[1] + "/" + operatorRSplit[1] + rightOperandRSplit[0] + ")" + rightOperandRSplit[1];
    }

    private String[] splitSpaceLeft(String nodeText)
    {
        String leftOperandTrimmed = nodeText;
        String spaceLeft = "";
        while (leftOperandTrimmed.matches("^\\s.*")) {
            spaceLeft += leftOperandTrimmed.substring(0, 1);
            leftOperandTrimmed = leftOperandTrimmed.substring(1);
        }
        return new String[]{spaceLeft, leftOperandTrimmed};
    }

    private String[] splitSpaceRight(String nodeText)
    {
        String rightOperandTrimmed = nodeText;
        String spaceRight = "";
        while (rightOperandTrimmed.matches(".*\\s$")) {
            spaceRight = rightOperandTrimmed.substring(rightOperandTrimmed.length() - 1, rightOperandTrimmed.length()) + spaceRight;
            rightOperandTrimmed = rightOperandTrimmed.substring(0, rightOperandTrimmed.length() - 1);
        }
        return new String[]{rightOperandTrimmed, spaceRight};
    }

    @Override
    public String visitTerminal(TerminalNode node)
    {
        String spaceLeft = getTerminalSpaceLeft(node.getSymbol().getStartIndex());
        String spaceRight = getTerminalSpaceRight(node.getSymbol().getStopIndex());

        String nodeText = node.getText();
        if (node.getSymbol().getType() == PSDGrammarParser.EQUAL) {
            nodeText = "==";
        }

        return spaceLeft + nodeText + spaceRight;
    }

    private String getTerminalSpaceLeft(int startIdx)
    {
        int leftSpaceIdx = startIdx;
        while (leftSpaceIdx > 0 && input.substring(leftSpaceIdx - 1, leftSpaceIdx).matches("\\s")) {
            leftSpaceIdx--;
        }
        if (leftSpaceIdx != 0) {
            // do left space-exploring only on the beginning of the input
            leftSpaceIdx = startIdx;
        }
        return input.substring(leftSpaceIdx, startIdx);
    }

    private String getTerminalSpaceRight(int stopIdx)
    {
        int rightSpaceIdx = stopIdx + 1;
        while (rightSpaceIdx < input.length() && input.substring(rightSpaceIdx, rightSpaceIdx + 1).matches("\\s")) {
            rightSpaceIdx++;
        }
        return input.substring(stopIdx + 1, rightSpaceIdx);
    }

    @Override
    protected String aggregateResult(String aggregate, String nextResult)
    {
        if (aggregate == null && nextResult == null) {
            return "";
        }
        if (aggregate == null) {
            return nextResult;
        }
        if (nextResult == null) {
            return aggregate;
        }

        return aggregate + nextResult;
    }

}
