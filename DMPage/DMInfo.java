package dongman;

public class DMInfo {
    private String name;
    private String author;
    private  String ticket;
    public DMInfo(){
    }
    public DMInfo(String name, String author, String ticket) {
        this.name = name;
        this.author = author;
        this.ticket = ticket;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    @Override
    public String toString() {
        return "DMInfo{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", ticket='" + ticket + '\'' +
                '}';
    }
}
