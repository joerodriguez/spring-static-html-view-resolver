spring-static-html-view-resolver
================================

For resolving views that are just static html. Useful if you don't want to redirect to an html resource

Here are some example beans. The first one is for resolving static html views with files ending in "static.html". 

The second resolver is for resolving thymeleaf views ending in ".html". Notice that the static html resolver is ordered first. If most of your views use thymeleaf or jsp, it may make sense to reverse the order and use a different suffix for static html views that don't conflict, such as ".html.static".

    @Bean
    public StaticHtmlViewResolver staticTemplateResolver() {
        StaticHtmlViewResolver resolver = new StaticHtmlViewResolver();
        resolver.setSuffix(".static.html");
        resolver.setPrefix("/views/");
        resolver.setOrder(1);

        return resolver;
    }

    @Bean
    public ServletContextTemplateResolver thymeleafTemplateResolver() {
        ServletContextTemplateResolver resolver = new ServletContextTemplateResolver();
        resolver.setPrefix("/views/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCacheable(false);
        resolver.setOrder(2);

        return resolver;
    }

