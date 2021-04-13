package cz.miroslavbartyzal.psdiagram.app.parser.antlr;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNodeImpl;

import cz.miroslavbartyzal.psdiagram.app.flowchart.Flowchart;
import cz.miroslavbartyzal.psdiagram.app.flowchart.layouts.LayoutElement;
import cz.miroslavbartyzal.psdiagram.app.flowchart.layouts.LayoutSegment;
import cz.miroslavbartyzal.psdiagram.app.flowchart.symbols.EnumSymbol;
import cz.miroslavbartyzal.psdiagram.app.flowchart.symbols.Symbol;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3BaseVisitor;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser.AtomContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser.ExprlistContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser.TestContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser.TestlistContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Python3Parser.Testlist_star_exprContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Java8Parser.ExpressionContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Java8Parser.StatementContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Java8Parser.StatementNoShortIfContext;
import cz.miroslavbartyzal.psdiagram.app.parser.Java8Parser.VariableDeclaratorIdContext;

public class PythonToPSDVisitor extends Python3BaseVisitor<Flowchart<LayoutSegment, LayoutElement>>{

	private static Flowchart<LayoutSegment, LayoutElement> flowchart;
	private static LayoutSegment actualSegment;
	private static LayoutElement lastElement;
	
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSingle_input(Python3Parser.Single_inputContext ctx) { 
		System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); 
		}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitFile_input(Python3Parser.File_inputContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitEval_input(Python3Parser.Eval_inputContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDecorator(Python3Parser.DecoratorContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDecorators(Python3Parser.DecoratorsContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDecorated(Python3Parser.DecoratedContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAsync_funcdef(Python3Parser.Async_funcdefContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitFuncdef(Python3Parser.FuncdefContext ctx) {
		actualSegment = new LayoutSegment(null);
        flowchart = new Flowchart<>(actualSegment);
        lastElement = actualSegment.addSymbol(null, EnumSymbol.STARTEND.getInstance(
                "Start"));
        actualSegment.addSymbol(lastElement, EnumSymbol.STARTEND.getInstance("End"));
        visitChildren(ctx);
		return flowchart;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitParameters(Python3Parser.ParametersContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTypedargslist(Python3Parser.TypedargslistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTfpdef(Python3Parser.TfpdefContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitVarargslist(Python3Parser.VarargslistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitVfpdef(Python3Parser.VfpdefContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitStmt(Python3Parser.StmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSimple_stmt(Python3Parser.Simple_stmtContext ctx) {
		System.out.println("simple context: " + ctx.getText());
		visitChildren(ctx);
		return flowchart;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSmall_stmt(Python3Parser.Small_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitExpr_stmt(Python3Parser.Expr_stmtContext ctx) {
		String var = "";
		String value = "";
		String exp = ctx.getText();
		String operator = "";
		if (ctx.getChildCount()>0) {
			for (ParseTree child : ctx.children) {
				if (child instanceof Testlist_star_exprContext) {
					if (var.equals("")) {
						var = child.getText();
					} else {
						value = child.getText();
					}
					
				}
				if (child instanceof TerminalNodeImpl) {
					operator = child.getText();
				}
			}
		}
		if ( !(var.equals("print") || value.equals("print")) ) {
			if (operator.equals("=")) {
				Symbol symbol = EnumSymbol.PROCESS.getInstance(exp);
				cz.miroslavbartyzal.psdiagram.app.gui.symbolFunctionForms.Process.generateValues(symbol,
						var, value);
				lastElement = actualSegment.addSymbol(lastElement, symbol);
			}
		}
		visitChildren(ctx); 
		return flowchart;	
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAnnassign(Python3Parser.AnnassignContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTestlist_star_expr(Python3Parser.Testlist_star_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAugassign(Python3Parser.AugassignContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDel_stmt(Python3Parser.Del_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitPass_stmt(Python3Parser.Pass_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitFlow_stmt(Python3Parser.Flow_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitBreak_stmt(Python3Parser.Break_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitContinue_stmt(Python3Parser.Continue_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitReturn_stmt(Python3Parser.Return_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitYield_stmt(Python3Parser.Yield_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitRaise_stmt(Python3Parser.Raise_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitImport_stmt(Python3Parser.Import_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitImport_name(Python3Parser.Import_nameContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitImport_from(Python3Parser.Import_fromContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitImport_as_name(Python3Parser.Import_as_nameContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDotted_as_name(Python3Parser.Dotted_as_nameContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitImport_as_names(Python3Parser.Import_as_namesContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDotted_as_names(Python3Parser.Dotted_as_namesContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDotted_name(Python3Parser.Dotted_nameContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitGlobal_stmt(Python3Parser.Global_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitNonlocal_stmt(Python3Parser.Nonlocal_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAssert_stmt(Python3Parser.Assert_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitCompound_stmt(Python3Parser.Compound_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAsync_stmt(Python3Parser.Async_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitIf_stmt(Python3Parser.If_stmtContext ctx) {
		LayoutElement tmpDecision = null;
		LayoutSegment tmpSegment = actualSegment;
		String condition = "true"; 
		if (ctx.getChildCount() > 0) {
			for (ParseTree child : ctx.children) {
				if (child instanceof TestContext) {
					condition = child.getText();
					lastElement = actualSegment.addSymbol(lastElement, EnumSymbol.DECISION.getInstance(condition));
					tmpDecision = lastElement;
					cz.miroslavbartyzal.psdiagram.app.gui.symbolFunctionForms.Decision.generateValues(lastElement.getSymbol(), condition);
					actualSegment = tmpDecision.getInnerSegment(1);
				}
			}
		}
		visitChildren(ctx);
		lastElement = tmpDecision;
		actualSegment = tmpSegment;
		return flowchart;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitWhile_stmt(Python3Parser.While_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitFor_stmt(Python3Parser.For_stmtContext ctx) {
		LayoutSegment tmpSegment = actualSegment;
		LayoutElement tmpElement = actualSegment.addSymbol(lastElement,
                EnumSymbol.FOR.getInstance(""));
		String var = "";
		String array = "";
		if(ctx.getChildCount()>0) {
			for(ParseTree child : ctx.children) {
				if (child instanceof ExprlistContext) {
					var = child.getText();
					if (var.startsWith(" ")) {
						var = var.substring(1);
					}
					
				}
				if (child instanceof TestlistContext) {
					array = child.getText();
					if (array.startsWith(" ")) {
						array = array.substring(1);
					}
				}
			}
			cz.miroslavbartyzal.psdiagram.app.gui.symbolFunctionForms.For.generateForeachValues(
					tmpElement.getSymbol(), var, array);
			tmpElement.getSymbol().setValueAndSize(
					tmpElement.getSymbol().getDefaultValue());
		}
		actualSegment = tmpElement.getInnerSegment(1);
		visitChildren(ctx);
		actualSegment = tmpSegment;
		return flowchart;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTry_stmt(Python3Parser.Try_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitWith_stmt(Python3Parser.With_stmtContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitWith_item(Python3Parser.With_itemContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitExcept_clause(Python3Parser.Except_clauseContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSuite(Python3Parser.SuiteContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTest(Python3Parser.TestContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTest_nocond(Python3Parser.Test_nocondContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitLambdef(Python3Parser.LambdefContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitLambdef_nocond(Python3Parser.Lambdef_nocondContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitOr_test(Python3Parser.Or_testContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAnd_test(Python3Parser.And_testContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitNot_test(Python3Parser.Not_testContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitComparison(Python3Parser.ComparisonContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitComp_op(Python3Parser.Comp_opContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitStar_expr(Python3Parser.Star_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitExpr(Python3Parser.ExprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitXor_expr(Python3Parser.Xor_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAnd_expr(Python3Parser.And_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitShift_expr(Python3Parser.Shift_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitArith_expr(Python3Parser.Arith_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTerm(Python3Parser.TermContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitFactor(Python3Parser.FactorContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitPower(Python3Parser.PowerContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAtom_expr(Python3Parser.Atom_exprContext ctx) {
		if (ctx.getText().startsWith("print")) {
			String toPrint = ctx.getText();
			int beginIndex = toPrint.indexOf('(');
			int endIndex = toPrint.lastIndexOf(')');
			toPrint = toPrint.substring(beginIndex+1, endIndex);
			Symbol symbol = EnumSymbol.IO.getInstance("");
			cz.miroslavbartyzal.psdiagram.app.gui.symbolFunctionForms.IO.generateOValues(symbol, toPrint);
			symbol.setValueAndSize(symbol.getDefaultValue());
			lastElement = actualSegment.addSymbol(lastElement, symbol);	
		}
		visitChildren(ctx);return flowchart; 
		}
	/**
	 * {@inheritDoc}
	 *StmtContext
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitAtom(Python3Parser.AtomContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTestlist_comp(Python3Parser.Testlist_compContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTrailer(Python3Parser.TrailerContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSubscriptlist(Python3Parser.SubscriptlistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSubscript(Python3Parser.SubscriptContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitSliceop(Python3Parser.SliceopContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitExprlist(Python3Parser.ExprlistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitTestlist(Python3Parser.TestlistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitDictorsetmaker(Python3Parser.DictorsetmakerContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitClassdef(Python3Parser.ClassdefContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitArglist(Python3Parser.ArglistContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitArgument(Python3Parser.ArgumentContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitComp_iter(Python3Parser.Comp_iterContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitComp_for(Python3Parser.Comp_forContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitComp_if(Python3Parser.Comp_ifContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitEncoding_decl(Python3Parser.Encoding_declContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitYield_expr(Python3Parser.Yield_exprContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation returns the result of calling
	 * {@link #visitChildren} on {@code ctx}.</p>
	 */
	@Override public Flowchart<LayoutSegment, LayoutElement> visitYield_arg(Python3Parser.Yield_argContext ctx) {System.out.println(ctx.getText() + " of instance: " + ctx.getClass().getSimpleName());return visitChildren(ctx); }
}
