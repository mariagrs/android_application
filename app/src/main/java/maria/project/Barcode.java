package maria.project;

public class Barcode {
    private String codeBarre;
    private String produit;
    private Integer prix;
    private Integer amount;

    public Barcode() {
    }

    public Barcode(String codeBarre, String produit, Integer prix) {
        this.codeBarre = codeBarre;
        this.produit = produit;
        this.prix = prix;
    }

    public Barcode(String produit, Integer prix , Integer amount) {
        this.produit = produit;
        this.prix = prix;
        this.amount = amount;
    }


    public String getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(String codeBarre) {
        this.codeBarre = codeBarre;
    }

    public String getProduit() {
        return produit;
    }

    public void setProduit(String produit) {
        this.produit = produit;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Barcode{" +
                "codeBarre='" + codeBarre + '\'' +
                ", produit='" + produit + '\'' +
                ", prix=" + prix +
                '}';
    }
}
