package com.springboot.societymaintenance.model;

        import com.fasterxml.jackson.annotation.JsonBackReference;

        import javax.persistence.*;
        import java.util.Date;

@Entity
public class Payment  implements  java.io.Serializable{

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FLAT_ID", nullable = false)
    @JsonBackReference
    private Flat flat;
    private Date paymentDate ;
    private int mode;
    private Double amount;
    private String referenceId;
    private String paymentComment;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flat getFlat() {
        return flat;
    }

    public void setFlat(Flat flat) {
        this.flat = flat;
    }


    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getPaymentComment() {
        return paymentComment;
    }

    public void setPaymentComment(String paymentComment) {
        this.paymentComment = paymentComment;
    }
}
