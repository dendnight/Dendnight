package com.dendnight.gallery.model;

import java.util.Date;

public class Image {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.id
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.height
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Integer height;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.width
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Integer width;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.file_size
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Integer fileSize;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.format
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String format;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.file_path
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String filePath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.created_by
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Integer createdBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.created_time
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Date createdTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.longitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Double longitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.latitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Double latitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.Camera_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String cameraBrand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.Camera_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String cameraModel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.lens_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String lensBrand;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.lens_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String lensModel;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.program_name
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private String programName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_image.date_taken
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    private Date dateTaken;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.id
     *
     * @return the value of t_image.id
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.id
     *
     * @param id the value for t_image.id
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.height
     *
     * @return the value of t_image.height
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.height
     *
     * @param height the value for t_image.height
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.width
     *
     * @return the value of t_image.width
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.width
     *
     * @param width the value for t_image.width
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.file_size
     *
     * @return the value of t_image.file_size
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Integer getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.file_size
     *
     * @param fileSize the value for t_image.file_size
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.format
     *
     * @return the value of t_image.format
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getFormat() {
        return format;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.format
     *
     * @param format the value for t_image.format
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setFormat(String format) {
        this.format = format == null ? null : format.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.file_path
     *
     * @return the value of t_image.file_path
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.file_path
     *
     * @param filePath the value for t_image.file_path
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.created_by
     *
     * @return the value of t_image.created_by
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Integer getCreatedBy() {
        return createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.created_by
     *
     * @param createdBy the value for t_image.created_by
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.created_time
     *
     * @return the value of t_image.created_time
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.created_time
     *
     * @param createdTime the value for t_image.created_time
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.longitude
     *
     * @return the value of t_image.longitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Double getLongitude() {
        return longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.longitude
     *
     * @param longitude the value for t_image.longitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.latitude
     *
     * @return the value of t_image.latitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Double getLatitude() {
        return latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.latitude
     *
     * @param latitude the value for t_image.latitude
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.Camera_brand
     *
     * @return the value of t_image.Camera_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getCameraBrand() {
        return cameraBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.Camera_brand
     *
     * @param cameraBrand the value for t_image.Camera_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setCameraBrand(String cameraBrand) {
        this.cameraBrand = cameraBrand == null ? null : cameraBrand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.Camera_model
     *
     * @return the value of t_image.Camera_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getCameraModel() {
        return cameraModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.Camera_model
     *
     * @param cameraModel the value for t_image.Camera_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setCameraModel(String cameraModel) {
        this.cameraModel = cameraModel == null ? null : cameraModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.lens_brand
     *
     * @return the value of t_image.lens_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getLensBrand() {
        return lensBrand;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.lens_brand
     *
     * @param lensBrand the value for t_image.lens_brand
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setLensBrand(String lensBrand) {
        this.lensBrand = lensBrand == null ? null : lensBrand.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.lens_model
     *
     * @return the value of t_image.lens_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getLensModel() {
        return lensModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.lens_model
     *
     * @param lensModel the value for t_image.lens_model
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setLensModel(String lensModel) {
        this.lensModel = lensModel == null ? null : lensModel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.program_name
     *
     * @return the value of t_image.program_name
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public String getProgramName() {
        return programName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.program_name
     *
     * @param programName the value for t_image.program_name
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setProgramName(String programName) {
        this.programName = programName == null ? null : programName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_image.date_taken
     *
     * @return the value of t_image.date_taken
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public Date getDateTaken() {
        return dateTaken;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_image.date_taken
     *
     * @param dateTaken the value for t_image.date_taken
     *
     * @mbggenerated Sun Feb 23 17:18:20 CST 2014
     */
    public void setDateTaken(Date dateTaken) {
        this.dateTaken = dateTaken;
    }
}