/**
 * Object to transfer data of request
 */
public class RequestData {
    String id;
    String base64JSON;

    public RequestData(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBase64JSON() {
        return base64JSON;
    }

    public void setBase64JSON(String base64JSON) {
        this.base64JSON = base64JSON;
    }
}
