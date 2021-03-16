package com.example.demo.domain.Image;

import java.util.UUID;

import javax.persistence.Embeddable;

@Embeddable
public class Image {
    public UUID asset_id;
    public UUID public_id;
    public String url;
    
}
