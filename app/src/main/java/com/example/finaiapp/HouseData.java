package com.example.finaiapp;

public class HouseData {

    //private float sale_yr; fields omitted for improved accuracy in model.
    //private float sale_month;
    //private float sale_day;
    private float bedrooms;
    //private float bathrooms;
    private float sqft_living;
    private float sqft_lot;
    //private float floors;
    //private float waterfront;
    //private float view;
    //private float condition;
    private float grade;
    //private float sqft_above;
    //private float sqft_basement;
    //private float yr_built;
    //private float yr_renovated;
    //private float zipcode;
    //private float lat;
    //private float longt;
    private float sqft_living15;
    private float sqft_lot15;
    private float predictedPrice;
    private String uid;
    private String createdDate;

    public HouseData(){
    }

    public HouseData( float bedrooms, float sqft_living, float sqft_lot, float grade, float sqft_living15, float sqft_lot15, float predictedPrice) {
        //this.sale_yr = sale_yr;
        //this.sale_month = sale_month;
        //this.sale_day = sale_day;
        this.bedrooms = bedrooms;
        //this.bathrooms = bathrooms;
        this.sqft_living = sqft_living;
        this.sqft_lot = sqft_lot;
        //this.floors = floors;
        //this.waterfront = waterfront;
        //this.view = view;
        //this.condition = condition;
        this.grade = grade;
        //this.sqft_above = sqft_above;
        //this.sqft_basement = sqft_basement;
        //this.yr_built = yr_built;
        //this.yr_renovated = yr_renovated;
        //this.zipcode = zipcode;
        //this.lat = lat;
        //this.longt = longt;
        this.sqft_living15 = sqft_living15;
        this.sqft_lot15 = sqft_lot15;
        this.predictedPrice = predictedPrice;
    }
    //public float getSale_yr() return sale_yr;}
    //public void setSale_yr(float sale_yr) {this.sale_yr = sale_yr;}
    //public float getSale_month() {return sale_month;}
    //public void setSale_month(float sale_month) {this.sale_month = sale_month;}
    //public float getSale_day() {return sale_day;}
    //public void setSale_day(float sale_day) {this.sale_day = sale_day;}
    public float getBedrooms() {return bedrooms;}
    public void setBedrooms(float bedrooms) {this.bedrooms = bedrooms;}
    //public float getBathrooms() {return bathrooms;}
    //public void setBathrooms(float bathrooms) {this.bathrooms = bathrooms;}

    public float getSqft_living() {
        return sqft_living;
    }

    public void setSqft_living(float sqft_living) {
        this.sqft_living = sqft_living;
    }

    public float getSqft_lot() {
        return sqft_lot;
    }

    public void setSqft_lot(float sqft_lot) {
        this.sqft_lot = sqft_lot;
    }

    //public float getFloors() {return floors;}
    //public void setFloors(float floors) {this.floors = floors;}
    //public float getWaterfront() {return waterfront;}
    //public void setWaterfront(float waterfront) {this.waterfront = waterfront;}
    //public float getView() {return view;}
    //public void setView(float view) {this.view = view;}
    //public float getCondition() {return condition;}
    //public void setCondition(float condition) {this.condition = condition;}

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    //public float getSqft_above() {return sqft_above;}
    //public void setSqft_above(float sqft_above) {this.sqft_above = sqft_above;}
    //public float getSqft_basement() {return sqft_basement;}
    //public void setSqft_basement(float sqft_basement) { this.sqft_basement = sqft_basement;}
    //public float getYr_built() {return yr_built;}
    //public void setYr_built(float yr_built) {this.yr_built = yr_built;}
    //public float getYr_renovated() { return yr_renovated;}
    //public void setYr_renovated(float yr_renovated) { this.yr_renovated = yr_renovated;  }
    //public float getZipcode() {return zipcode;}
    //public void setZipcode(float zipcode) {this.zipcode = zipcode;  }
    //public float getLat() {return lat;}
    //public void setLat(float lat) { this.lat = lat;}
    //public float getLongt() {return longt;}
    //public void setLongt(float longt) {this.longt = longt;}

    public float getSqft_living15() {
        return sqft_living15;
    }

    public void setSqft_living15(float sqft_living15) {
        this.sqft_living15 = sqft_living15;
    }

    public float getSqft_lot15() {
        return sqft_lot15;
    }

    public void setSqft_lot15(float sqft_lot15) {
        this.sqft_lot15 = sqft_lot15;
    }

    public float getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(float predictedPrice) {
        this.predictedPrice = predictedPrice;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

}

