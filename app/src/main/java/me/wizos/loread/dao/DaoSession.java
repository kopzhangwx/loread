package me.wizos.loread.dao;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import me.wizos.loread.bean.Tag;
import me.wizos.loread.bean.Feed;
import me.wizos.loread.bean.Article;
import me.wizos.loread.bean.RequestLog;

import me.wizos.loread.dao.TagDao;
import me.wizos.loread.dao.FeedDao;
import me.wizos.loread.dao.ArticleDao;
import me.wizos.loread.dao.RequestLogDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig tagDaoConfig;
    private final DaoConfig feedDaoConfig;
    private final DaoConfig articleDaoConfig;
    private final DaoConfig requestLogDaoConfig;

    private final TagDao tagDao;
    private final FeedDao feedDao;
    private final ArticleDao articleDao;
    private final RequestLogDao requestLogDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        tagDaoConfig = daoConfigMap.get(TagDao.class).clone();
        tagDaoConfig.initIdentityScope(type);

        feedDaoConfig = daoConfigMap.get(FeedDao.class).clone();
        feedDaoConfig.initIdentityScope(type);

        articleDaoConfig = daoConfigMap.get(ArticleDao.class).clone();
        articleDaoConfig.initIdentityScope(type);

        requestLogDaoConfig = daoConfigMap.get(RequestLogDao.class).clone();
        requestLogDaoConfig.initIdentityScope(type);

        tagDao = new TagDao(tagDaoConfig, this);
        feedDao = new FeedDao(feedDaoConfig, this);
        articleDao = new ArticleDao(articleDaoConfig, this);
        requestLogDao = new RequestLogDao(requestLogDaoConfig, this);

        registerDao(Tag.class, tagDao);
        registerDao(Feed.class, feedDao);
        registerDao(Article.class, articleDao);
        registerDao(RequestLog.class, requestLogDao);
    }
    
    public void clear() {
        tagDaoConfig.getIdentityScope().clear();
        feedDaoConfig.getIdentityScope().clear();
        articleDaoConfig.getIdentityScope().clear();
        requestLogDaoConfig.getIdentityScope().clear();
    }

    public TagDao getTagDao() {
        return tagDao;
    }

    public FeedDao getFeedDao() {
        return feedDao;
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    public RequestLogDao getRequestLogDao() {
        return requestLogDao;
    }

}