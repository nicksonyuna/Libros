
public class Pinjaman {

	String id, judul, penulis, tahunPublikasi;

	public Pinjaman(String id, String judul, String penulis, String tahunPublikasi) {
		super();
		this.id = id;
		this.judul = judul;
		this.penulis = penulis;
		this.tahunPublikasi = tahunPublikasi;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getJudul() {
		return judul;
	}

	public void setJudul(String judul) {
		this.judul = judul;
	}

	public String getPenulis() {
		return penulis;
	}

	public void setPenulis(String penulis) {
		this.penulis = penulis;
	}

	public String getTahunPublikasi() {
		return tahunPublikasi;
	}

	public void setTahunPublikasi(String tahunPublikasi) {
		this.tahunPublikasi = tahunPublikasi;
	}

	
}
