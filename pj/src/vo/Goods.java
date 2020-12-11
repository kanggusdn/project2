package vo;

public class Goods {
	private int id;
	private String kind;
	private String name;
	private int price;
	private String image;
	private String modalip;
	private String modalimage;
	
	
	
	public Goods(int id, String kind, String name, int price, String image, String modalip, String modalimage) {
		super();
		this.id = id;
		this.kind = kind;
		this.name = name;
		this.price = price;
		this.image = image;
		this.modalip = modalip;
		this.modalimage = modalimage;
	}

	public String getModalimage() {
		return modalimage;
	}

	public void setModalimage(String modalimage) {
		this.modalimage = modalimage;
	}

	public String getModalip() {
		return modalip;
	}

	public void setModalip(String modalip) {
		this.modalip = modalip;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
