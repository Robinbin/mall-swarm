package com.macro.mall.model;

import static com.macro.mall.constant.MbgConstants.ALBUM_PICS;
import static com.macro.mall.constant.MbgConstants.CATEGORY_ID;
import static com.macro.mall.constant.MbgConstants.CATEGORY_NAME;
import static com.macro.mall.constant.MbgConstants.COLLECT_COUNT;
import static com.macro.mall.constant.MbgConstants.COMMENT_COUNT;
import static com.macro.mall.constant.MbgConstants.CREATE_TIME;
import static com.macro.mall.constant.MbgConstants.DESCRIPTION;
import static com.macro.mall.constant.MbgConstants.FORWARD_COUNT;
import static com.macro.mall.constant.MbgConstants.ID;
import static com.macro.mall.constant.MbgConstants.PIC;
import static com.macro.mall.constant.MbgConstants.PRODUCT_COUNT;
import static com.macro.mall.constant.MbgConstants.READ_COUNT;
import static com.macro.mall.constant.MbgConstants.RECOMMEND_STATUS;
import static com.macro.mall.constant.MbgConstants.SHOW_STATUS;
import static com.macro.mall.constant.MbgConstants.TITLE;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CmsSubjectExample {

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CmsSubjectExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {

        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, ID);
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, ID);
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, ID);
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(Long value) {
            addCriterion("category_id =", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Long value) {
            addCriterion("category_id <>", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Long value) {
            addCriterion("category_id >", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Long value) {
            addCriterion("category_id >=", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Long value) {
            addCriterion("category_id <", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Long value) {
            addCriterion("category_id <=", value, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Long> values) {
            addCriterion("category_id in", values, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Long> values) {
            addCriterion("category_id not in", values, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Long value1, Long value2) {
            addCriterion("category_id between", value1, value2, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Long value1, Long value2) {
            addCriterion("category_id not between", value1, value2, CATEGORY_ID);
            return (Criteria) this;
        }

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, TITLE);
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, TITLE);
            return (Criteria) this;
        }

        public Criteria andPicIsNull() {
            addCriterion("pic is null");
            return (Criteria) this;
        }

        public Criteria andPicIsNotNull() {
            addCriterion("pic is not null");
            return (Criteria) this;
        }

        public Criteria andPicEqualTo(String value) {
            addCriterion("pic =", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicNotEqualTo(String value) {
            addCriterion("pic <>", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicGreaterThan(String value) {
            addCriterion("pic >", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicGreaterThanOrEqualTo(String value) {
            addCriterion("pic >=", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicLessThan(String value) {
            addCriterion("pic <", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicLessThanOrEqualTo(String value) {
            addCriterion("pic <=", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicLike(String value) {
            addCriterion("pic like", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicNotLike(String value) {
            addCriterion("pic not like", value, PIC);
            return (Criteria) this;
        }

        public Criteria andPicIn(List<String> values) {
            addCriterion("pic in", values, PIC);
            return (Criteria) this;
        }

        public Criteria andPicNotIn(List<String> values) {
            addCriterion("pic not in", values, PIC);
            return (Criteria) this;
        }

        public Criteria andPicBetween(String value1, String value2) {
            addCriterion("pic between", value1, value2, PIC);
            return (Criteria) this;
        }

        public Criteria andPicNotBetween(String value1, String value2) {
            addCriterion("pic not between", value1, value2, PIC);
            return (Criteria) this;
        }

        public Criteria andProductCountIsNull() {
            addCriterion("product_count is null");
            return (Criteria) this;
        }

        public Criteria andProductCountIsNotNull() {
            addCriterion("product_count is not null");
            return (Criteria) this;
        }

        public Criteria andProductCountEqualTo(Integer value) {
            addCriterion("product_count =", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountNotEqualTo(Integer value) {
            addCriterion("product_count <>", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThan(Integer value) {
            addCriterion("product_count >", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_count >=", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountLessThan(Integer value) {
            addCriterion("product_count <", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountLessThanOrEqualTo(Integer value) {
            addCriterion("product_count <=", value, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountIn(List<Integer> values) {
            addCriterion("product_count in", values, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountNotIn(List<Integer> values) {
            addCriterion("product_count not in", values, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountBetween(Integer value1, Integer value2) {
            addCriterion("product_count between", value1, value2, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andProductCountNotBetween(Integer value1, Integer value2) {
            addCriterion("product_count not between", value1, value2, PRODUCT_COUNT);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNull() {
            addCriterion("recommend_status is null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIsNotNull() {
            addCriterion("recommend_status is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendStatusEqualTo(Integer value) {
            addCriterion("recommend_status =", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotEqualTo(Integer value) {
            addCriterion("recommend_status <>", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThan(Integer value) {
            addCriterion("recommend_status >", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("recommend_status >=", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThan(Integer value) {
            addCriterion("recommend_status <", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusLessThanOrEqualTo(Integer value) {
            addCriterion("recommend_status <=", value, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusIn(List<Integer> values) {
            addCriterion("recommend_status in", values, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotIn(List<Integer> values) {
            addCriterion("recommend_status not in", values, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status between", value1, value2, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andRecommendStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("recommend_status not between", value1, value2, RECOMMEND_STATUS);
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, CREATE_TIME);
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNull() {
            addCriterion("collect_count is null");
            return (Criteria) this;
        }

        public Criteria andCollectCountIsNotNull() {
            addCriterion("collect_count is not null");
            return (Criteria) this;
        }

        public Criteria andCollectCountEqualTo(Integer value) {
            addCriterion("collect_count =", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountNotEqualTo(Integer value) {
            addCriterion("collect_count <>", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThan(Integer value) {
            addCriterion("collect_count >", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_count >=", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThan(Integer value) {
            addCriterion("collect_count <", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountLessThanOrEqualTo(Integer value) {
            addCriterion("collect_count <=", value, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountIn(List<Integer> values) {
            addCriterion("collect_count in", values, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountNotIn(List<Integer> values) {
            addCriterion("collect_count not in", values, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountBetween(Integer value1, Integer value2) {
            addCriterion("collect_count between", value1, value2, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCollectCountNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_count not between", value1, value2, COLLECT_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountIsNull() {
            addCriterion("read_count is null");
            return (Criteria) this;
        }

        public Criteria andReadCountIsNotNull() {
            addCriterion("read_count is not null");
            return (Criteria) this;
        }

        public Criteria andReadCountEqualTo(Integer value) {
            addCriterion("read_count =", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountNotEqualTo(Integer value) {
            addCriterion("read_count <>", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThan(Integer value) {
            addCriterion("read_count >", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("read_count >=", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountLessThan(Integer value) {
            addCriterion("read_count <", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountLessThanOrEqualTo(Integer value) {
            addCriterion("read_count <=", value, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountIn(List<Integer> values) {
            addCriterion("read_count in", values, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountNotIn(List<Integer> values) {
            addCriterion("read_count not in", values, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountBetween(Integer value1, Integer value2) {
            addCriterion("read_count between", value1, value2, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andReadCountNotBetween(Integer value1, Integer value2) {
            addCriterion("read_count not between", value1, value2, READ_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNull() {
            addCriterion("comment_count is null");
            return (Criteria) this;
        }

        public Criteria andCommentCountIsNotNull() {
            addCriterion("comment_count is not null");
            return (Criteria) this;
        }

        public Criteria andCommentCountEqualTo(Integer value) {
            addCriterion("comment_count =", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountNotEqualTo(Integer value) {
            addCriterion("comment_count <>", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThan(Integer value) {
            addCriterion("comment_count >", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_count >=", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThan(Integer value) {
            addCriterion("comment_count <", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountLessThanOrEqualTo(Integer value) {
            addCriterion("comment_count <=", value, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountIn(List<Integer> values) {
            addCriterion("comment_count in", values, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountNotIn(List<Integer> values) {
            addCriterion("comment_count not in", values, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountBetween(Integer value1, Integer value2) {
            addCriterion("comment_count between", value1, value2, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andCommentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_count not between", value1, value2, COMMENT_COUNT);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIsNull() {
            addCriterion("album_pics is null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIsNotNull() {
            addCriterion("album_pics is not null");
            return (Criteria) this;
        }

        public Criteria andAlbumPicsEqualTo(String value) {
            addCriterion("album_pics =", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotEqualTo(String value) {
            addCriterion("album_pics <>", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsGreaterThan(String value) {
            addCriterion("album_pics >", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsGreaterThanOrEqualTo(String value) {
            addCriterion("album_pics >=", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLessThan(String value) {
            addCriterion("album_pics <", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLessThanOrEqualTo(String value) {
            addCriterion("album_pics <=", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsLike(String value) {
            addCriterion("album_pics like", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotLike(String value) {
            addCriterion("album_pics not like", value, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsIn(List<String> values) {
            addCriterion("album_pics in", values, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotIn(List<String> values) {
            addCriterion("album_pics not in", values, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsBetween(String value1, String value2) {
            addCriterion("album_pics between", value1, value2, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andAlbumPicsNotBetween(String value1, String value2) {
            addCriterion("album_pics not between", value1, value2, ALBUM_PICS);
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, DESCRIPTION);
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNull() {
            addCriterion("show_status is null");
            return (Criteria) this;
        }

        public Criteria andShowStatusIsNotNull() {
            addCriterion("show_status is not null");
            return (Criteria) this;
        }

        public Criteria andShowStatusEqualTo(Integer value) {
            addCriterion("show_status =", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusNotEqualTo(Integer value) {
            addCriterion("show_status <>", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThan(Integer value) {
            addCriterion("show_status >", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("show_status >=", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThan(Integer value) {
            addCriterion("show_status <", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusLessThanOrEqualTo(Integer value) {
            addCriterion("show_status <=", value, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusIn(List<Integer> values) {
            addCriterion("show_status in", values, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusNotIn(List<Integer> values) {
            addCriterion("show_status not in", values, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusBetween(Integer value1, Integer value2) {
            addCriterion("show_status between", value1, value2, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andShowStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("show_status not between", value1, value2, SHOW_STATUS);
            return (Criteria) this;
        }

        public Criteria andForwardCountIsNull() {
            addCriterion("forward_count is null");
            return (Criteria) this;
        }

        public Criteria andForwardCountIsNotNull() {
            addCriterion("forward_count is not null");
            return (Criteria) this;
        }

        public Criteria andForwardCountEqualTo(Integer value) {
            addCriterion("forward_count =", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountNotEqualTo(Integer value) {
            addCriterion("forward_count <>", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountGreaterThan(Integer value) {
            addCriterion("forward_count >", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("forward_count >=", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountLessThan(Integer value) {
            addCriterion("forward_count <", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountLessThanOrEqualTo(Integer value) {
            addCriterion("forward_count <=", value, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountIn(List<Integer> values) {
            addCriterion("forward_count in", values, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountNotIn(List<Integer> values) {
            addCriterion("forward_count not in", values, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountBetween(Integer value1, Integer value2) {
            addCriterion("forward_count between", value1, value2, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andForwardCountNotBetween(Integer value1, Integer value2) {
            addCriterion("forward_count not between", value1, value2, FORWARD_COUNT);
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNull() {
            addCriterion("category_name is null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameIsNotNull() {
            addCriterion("category_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryNameEqualTo(String value) {
            addCriterion("category_name =", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotEqualTo(String value) {
            addCriterion("category_name <>", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThan(String value) {
            addCriterion("category_name >", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameGreaterThanOrEqualTo(String value) {
            addCriterion("category_name >=", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThan(String value) {
            addCriterion("category_name <", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLessThanOrEqualTo(String value) {
            addCriterion("category_name <=", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameLike(String value) {
            addCriterion("category_name like", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotLike(String value) {
            addCriterion("category_name not like", value, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameIn(List<String> values) {
            addCriterion("category_name in", values, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotIn(List<String> values) {
            addCriterion("category_name not in", values, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameBetween(String value1, String value2) {
            addCriterion("category_name between", value1, value2, CATEGORY_NAME);
            return (Criteria) this;
        }

        public Criteria andCategoryNameNotBetween(String value1, String value2) {
            addCriterion("category_name not between", value1, value2, CATEGORY_NAME);
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {

        private final String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private final String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}