package com.risk.common.page;



public class PageContext extends Page {

    private static ThreadLocal<Page> context = new ThreadLocal<Page>();

    /**
     * 获取上下文参数.
     *
     * @return
     */
    public static Page getContext() {
        Page ci = context.get();
        if (ci == null) {
            ci = new Page();
            context.set(ci);
        }
        return ci;
    }

    /**
     * 设置上下文参数.
     *
     * @param page
     */
    public static void setContext(Page page) {
        context.set(page);
    }


    public static void removeContext() {
        context.remove();
    }

    protected void initialize() {


    }


}
