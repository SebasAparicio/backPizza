package com.example.demo.domain;

import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class Image {
    public String asset_id;
    public UUID public_id;
    public String url;
    
}
