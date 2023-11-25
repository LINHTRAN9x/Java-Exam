package demo5.INewsTets;

import java.util.ArrayList;

public class News implements INewsInterface {
    private int ID;
    private String Title;
    private String PublishDate;
    private String Author;
    private String Content;
    private float AverageRate;

    private ArrayList<Integer> RateList = new ArrayList<>();

    public void inputRate(int rating){
        if(rating >= 1 && rating <= 5){
            RateList.add(rating);
            return;
        }return;
    }
    public float Calculate() {
        float sum = 0;

        for (Integer r : RateList) {
            sum += r;
        }

        return AverageRate =  sum / RateList.size();
    }

    public News(int ID, String title, String publishDate, String author, String content) {
        this.ID = ID;
        Title = title;
        PublishDate = publishDate;
        Author = author;
        Content = content;

    }

    public float getAverageRate() {
        return AverageRate;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getPublishDate() {
        return PublishDate;
    }

    public void setPublishDate(String publishDate) {
        PublishDate = publishDate;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    @Override
    public void Display() {
        System.out.println("Title: "+ getTitle());
        System.out.println("PublishDate: "+ getPublishDate());
        System.out.println("Author: " + getAuthor());
        System.out.println("Content: " + getContent());
        System.out.println("AverageRate: " + getAverageRate());
        System.out.println(RateList.size());
    }

}
