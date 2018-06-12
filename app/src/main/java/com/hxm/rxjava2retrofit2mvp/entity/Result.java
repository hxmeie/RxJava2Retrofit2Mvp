package com.hxm.rxjava2retrofit2mvp.entity;

import java.util.List;

/**
 * Created by hxm on 2018/6/12
 * 描述：
 */
public class Result {

    /**
     * status : 200
     * msg : OK
     * data : {"resultMap":{"total":1,"pages":1,"data":[{"id":"0a927db2c25847c9905febe29bf2964f","topic":"《慧分期》2018年5月31日上线 - 测试测试测试","content":"一、简介\r\n慧分期为广大消费者提供消费分期服务，由壹壹财富投资管理有限公司提供。客户可通过慧分期APP办理消费分期业务。\r\n2018年5月31日慧分期上线了电动车分期业务，为辛劳的外卖配送小哥提供电动车分期服务。\r\n\r\n二、\t申请条件\r\n1.\t已经被快递公司录用的外卖配送小哥。\r\n2.\t年龄18至50周岁\r\n\r\n三、\t申请资料\r\n1.\t身份证原件\r\n2.\t银行借记卡\r\n3.\t入职证明\r\n\r\n四、\t办理方法\r\n1.\t入职慧分期合作的外卖公司，详情咨询销售代表。\r\n2.\t准备申请资料。\r\n3.\t联系我司销售代表办理。\r\n\r\n商务合作电话：010-53354394  \r\n电子邮箱：changlw@yiyicf.com","creater":"系统管理员","createDate":"2018-05-31","updater":null,"updateDate":null}]}}
     */

    private int status;
    private String msg;
    private DataBeanX data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * resultMap : {"total":1,"pages":1,"data":[{"id":"0a927db2c25847c9905febe29bf2964f","topic":"《慧分期》2018年5月31日上线 - 测试测试测试","content":"一、简介\r\n慧分期为广大消费者提供消费分期服务，由壹壹财富投资管理有限公司提供。客户可通过慧分期APP办理消费分期业务。\r\n2018年5月31日慧分期上线了电动车分期业务，为辛劳的外卖配送小哥提供电动车分期服务。\r\n\r\n二、\t申请条件\r\n1.\t已经被快递公司录用的外卖配送小哥。\r\n2.\t年龄18至50周岁\r\n\r\n三、\t申请资料\r\n1.\t身份证原件\r\n2.\t银行借记卡\r\n3.\t入职证明\r\n\r\n四、\t办理方法\r\n1.\t入职慧分期合作的外卖公司，详情咨询销售代表。\r\n2.\t准备申请资料。\r\n3.\t联系我司销售代表办理。\r\n\r\n商务合作电话：010-53354394  \r\n电子邮箱：changlw@yiyicf.com","creater":"系统管理员","createDate":"2018-05-31","updater":null,"updateDate":null}]}
         */

        private ResultMapBean resultMap;

        public ResultMapBean getResultMap() {
            return resultMap;
        }

        public void setResultMap(ResultMapBean resultMap) {
            this.resultMap = resultMap;
        }

        public static class ResultMapBean {
            /**
             * total : 1
             * pages : 1
             * data : [{"id":"0a927db2c25847c9905febe29bf2964f","topic":"《慧分期》2018年5月31日上线 - 测试测试测试","content":"一、简介\r\n慧分期为广大消费者提供消费分期服务，由壹壹财富投资管理有限公司提供。客户可通过慧分期APP办理消费分期业务。\r\n2018年5月31日慧分期上线了电动车分期业务，为辛劳的外卖配送小哥提供电动车分期服务。\r\n\r\n二、\t申请条件\r\n1.\t已经被快递公司录用的外卖配送小哥。\r\n2.\t年龄18至50周岁\r\n\r\n三、\t申请资料\r\n1.\t身份证原件\r\n2.\t银行借记卡\r\n3.\t入职证明\r\n\r\n四、\t办理方法\r\n1.\t入职慧分期合作的外卖公司，详情咨询销售代表。\r\n2.\t准备申请资料。\r\n3.\t联系我司销售代表办理。\r\n\r\n商务合作电话：010-53354394  \r\n电子邮箱：changlw@yiyicf.com","creater":"系统管理员","createDate":"2018-05-31","updater":null,"updateDate":null}]
             */

            private int total;
            private int pages;
            private List<DataBean> data;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public List<DataBean> getData() {
                return data;
            }

            public void setData(List<DataBean> data) {
                this.data = data;
            }

            public static class DataBean {
                /**
                 * id : 0a927db2c25847c9905febe29bf2964f
                 * topic : 《慧分期》2018年5月31日上线 - 测试测试测试
                 * content : 一、简介
                 * 慧分期为广大消费者提供消费分期服务，由壹壹财富投资管理有限公司提供。客户可通过慧分期APP办理消费分期业务。
                 * 2018年5月31日慧分期上线了电动车分期业务，为辛劳的外卖配送小哥提供电动车分期服务。
                 * <p>
                 * 二、	申请条件
                 * 1.	已经被快递公司录用的外卖配送小哥。
                 * 2.	年龄18至50周岁
                 * <p>
                 * 三、	申请资料
                 * 1.	身份证原件
                 * 2.	银行借记卡
                 * 3.	入职证明
                 * <p>
                 * 四、	办理方法
                 * 1.	入职慧分期合作的外卖公司，详情咨询销售代表。
                 * 2.	准备申请资料。
                 * 3.	联系我司销售代表办理。
                 * <p>
                 * 商务合作电话：010-53354394
                 * 电子邮箱：changlw@yiyicf.com
                 * creater : 系统管理员
                 * createDate : 2018-05-31
                 * updater : null
                 * updateDate : null
                 */

                private String id;
                private String topic;
                private String content;
                private String creater;
                private String createDate;
                private Object updater;
                private Object updateDate;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTopic() {
                    return topic;
                }

                public void setTopic(String topic) {
                    this.topic = topic;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCreater() {
                    return creater;
                }

                public void setCreater(String creater) {
                    this.creater = creater;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public Object getUpdater() {
                    return updater;
                }

                public void setUpdater(Object updater) {
                    this.updater = updater;
                }

                public Object getUpdateDate() {
                    return updateDate;
                }

                public void setUpdateDate(Object updateDate) {
                    this.updateDate = updateDate;
                }
            }
        }
    }
}
