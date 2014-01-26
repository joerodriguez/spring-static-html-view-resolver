public class StaticHtmlViewResolver extends org.springframework.web.servlet.view.AbstractCachingViewResolver implements org.springframework.core.Ordered {
    private int order;
    private String prefix = "";
    private String suffix = "";

    @Override
    protected View loadView(String viewName, Locale locale) throws Exception {
        Resource resource = getApplicationContext().getResource(prefix + viewName + suffix);

        if (resource.exists()) {
            return new StaticHtmlView(resource.getFile());
        }

        return null;
    }

    @Override
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }


    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

}
