public class StaticHtmlView implements View {

    private File htmlFile;

    public StaticHtmlView(File htmlFile) {
        this.htmlFile = htmlFile;
    }

    public static void copy(InputStream input, OutputStream output) throws IOException {
        byte[] buf = new byte[10];
        int bytesRead = input.read(buf);
        while (bytesRead != -1) {
            output.write(buf, 0, bytesRead);
            bytesRead = input.read(buf);
        }
        output.flush();
    }

    @Override
    public String getContentType() {
        return "text/html";
    }

    @Override
    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        copy(new FileInputStream(htmlFile), baos);

        // Write content type and also length (determined via byte array).
        response.setContentType(getContentType());
        response.setContentLength(baos.size());

        // Flush byte array to servlet output stream.
        ServletOutputStream out = response.getOutputStream();
        baos.writeTo(out);
        out.flush();
    }
}