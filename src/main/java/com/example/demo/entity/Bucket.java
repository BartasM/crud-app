package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="bucket")
public class Bucket {

    @Id
    @Column(name="bucket_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bucket_seq")
    @SequenceGenerator(name = "bucket_seq", sequenceName = "SEQ_BUCKET", allocationSize = 1)
    private Long bucketId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    @OneToMany(mappedBy = "bucket", cascade = CascadeType.ALL,orphanRemoval = true, fetch=FetchType.EAGER)
    private Set<BucketPosition> bucketPosition;

    public Long getBucketId() {
        return bucketId;
    }

    public void setBucketId(Long bucketId) {
        this.bucketId = bucketId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<BucketPosition> getBucketPosition() {
        return bucketPosition;
    }

    public void setBucketPosition(Set<BucketPosition> bucketPosition) {
        this.bucketPosition = bucketPosition;
    }
}
