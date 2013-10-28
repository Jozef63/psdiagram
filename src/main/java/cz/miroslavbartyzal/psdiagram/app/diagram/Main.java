/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.miroslavbartyzal.psdiagram.app.diagram;

import cz.miroslavbartyzal.psdiagram.app.diagram.gui.MainWindow;
import javax.swing.ToolTipManager;

/**
 * Hlavní třída obsahující main metodu, sloužící pro spuštění hlavního
 * okna aplikace.
 *
 * @author Miroslav Bartyzal (miroslavbartyzal@gmail.com)
 */
public final class Main
{
    // TODO nastaveni zarovnavani komentarovych textu
    // TODO zakomponovat priklady do vyuky primo jako soucast aplikace
    // TODO zoom k mysi
    // TODO odkazy na weby obrazku
    // TODO exception handling: http://stackoverflow.com/questions/4590295/catch-exception-high-in-the-call-stack-when-dealing-with-n-tiers
    // TODO logovani
    // TODO pridat info o verzi a licenci
    // TODO pridat (defaultne vypnute?) nastaveni automatickeho nacitani predchozi (i neulozene) prace - pak nemusim rikat ze bude prace ztracena, kdyz zaviram okno (ale pri vytvareni noveho diagramu ano)
    // TODO prepnuti focusu i pri editaci funkce symbolu
    // TODO ukolovani studentu? (seradit spravne kroky algoritmu, vyuziti jen urciteho poctu prikazu apod.)
    // TODO možnost nastavení barev v editacnim i animacnim rezimu
    // TODO po dvojitem poklepani na symbol, prepnout docasne na zalozku Text (nebo toggle?) Docasne proto, aby po vlozeni dalsiho symbolu jiz byla opet vybrana Funkce
    // TODO doplnit priklad modula (+ celociselneho deleni) do symbolu procesu
    // TODO pro skoly nechat defaultni nastaveni jako readonly soubor xml primo u aplikace (co ale s prekopirovanim domu?)
    // TODO prepnout focus pri psani i do textboxu Funkce symbolu
    // TODO menit i zeditovany text symbolu, pokud je zeditovany pouze o mezery ci odradkovani (nebo tak vymyslet automaticke odradkovavani?)
    // TODO moznost nastaveni prirazovaciho znamenka
    // TODO moznost prepnuti mezi Do-Until a Do-While
    // TODO doplnit celociselny podil (DIV v pascalu)
    // TODO pridat labely kdyz a pak u podminky v panelu funkce?
    // TODO pomoci tranc preklopit TBLR layout na LFTB? :)
    // TODO mail Havelkova 19.4.
    // TODO misto blokovani syntaktickym filtrem, pouze zcervenit
    // TODO umoznit editaci vytvorenych promennych? (za behu animace)
    // TODO uvazit prebarveni pozadi animace - kouknout na to s modrym odstinem z prezentace diplomek
    // TODO vedle exportu do obrázku a PDF, vytvořit export do HTML! :)
    // TODO dat uzivateli vedet ze pri exportu do obrazku zalezi na aktualnim zvetseni! (nebo to udelat nejak jinak)
    // TODO pridat input symbolu text, aby nebylo nutne pouzivat output symbol pro oznameni co promenna znamena..
    // TODO animace pridavani symbolu
    // TODO moznost promitani vytvořených algritmů na webu (pro pasivní učení a prezentaci)? - Jelinek
    // TODO merit zakovi cas za ktery ulohu vykona, monitorovat problemy, se kterymi se setkal (co treba zachovavat vsechny stavy diagramu?) - Jelinek
    // TODO Timer jako procedura (interrupt či vlákno)
    // TODO mrkni na http://jelastic.com/ a na jejich barvy, maji to cool :)
    // TODO vynechat package diagram?
    // TODO zkontrolovat obfuskaci po upgradu proguardu
    // TODO check these: http://sourceforge.net/projects/flowcharts/?source=recommended, http://sourceforge.net/projects/simpeflowd/?source=recommended, http://sourceforge.net/projects/devflowcharter/?source=recommended, http://sourceforge.net/projects/javablock/
    // TODO sjednotit jazyk na EN (dokumentace)
    // TODO inspiruj se, koukni na Scratch
    // TODO pamatovat si velikost oken (http://stackoverflow.com/questions/7777640/best-practice-for-setting-jframe-locations)
    // TODO pri vyprseni zkusebky umoznit stahnout pripadnou aktualizaci
    // TODO co je vsechno v jaru? chci tam pom?
    // TODO otestovat kdyz chybi consolas
    // TODO aktualizovat iconu
    // TODO zahrnout do instalacky JRE, aby nemusela byt na cilovce java - updater pak musi fungovat jako synchronizator, aby balik nebyl zbytecne moc velky
    // TODO .exe soubor?
    // TODO Pascal podpora vice vstupu naraz - prikaz read[ln](x,y,z)
    // TODO po includovani JRE upravit manual

    /**
     * Metoda pro spuštění hlavního okna aplikace. Nejsou přijímány žádné
     * parametry.
     * <p>
     * @param args
     */
    public static void main(String[] args)
    {
        ToolTipManager.sharedInstance().setDismissDelay(12000); // nastavení tooltipu tak, aby zustali 12 sekund
        MainWindow.main(args);
    }

}
