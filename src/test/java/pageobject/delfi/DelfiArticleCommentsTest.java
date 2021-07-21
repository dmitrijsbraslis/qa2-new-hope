package pageobject.delfi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pageobject.delfi.pages.ArticlePage;
import pageobject.BaseFunc;
import pageobject.delfi.pages.HomePage;

public class DelfiArticleCommentsTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private final int ARTICLE_ID = 5;

    private BaseFunc baseFunc;

    @Test
    public void titleAndCommentsCountCheck() {
        LOGGER.info("This test is checking titles and comments count on home/article/comments pages");

        baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        //---------------------------HOME PAGE-----------------------------------------------------------
        HomePage homePage = new HomePage(baseFunc);
        homePage.acceptCookies();

        String homePageTitle = homePage.getTitle(ARTICLE_ID);
        int homePageCommentsCount = homePage.getCommentsCount(ARTICLE_ID);

        ArticlePage articlePage = homePage.openArticle(ARTICLE_ID);

        //-------------------------ARTICLE PAGE----------------------------------------------------------
        String articlePageTitle = articlePage.getTitle();
        int articlePageCommentsCount = articlePage.getCommentsCount();

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentsCount, "Wrong comments count!");

        articlePage.openCommentsPage();
        //-------------------------COMMENTS PAGE---------------------------------------------------------
        //...
    }

    @AfterEach
    public void closeBrowser() {
        baseFunc.closeBrowser();
    }
}
