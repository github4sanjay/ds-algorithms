package com.github4sanjay.dsalgo;

import com.google.gson.*;
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.*;

public class GetMovieTitles {
  /*
   * Complete the function below.
   * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
   */

  public static class Page {
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Data> data;

    public int getPage() {
      return page;
    }

    public void setPage(int page) {
      this.page = page;
    }

    public int getPer_page() {
      return per_page;
    }

    public void setPer_page(int per_page) {
      this.per_page = per_page;
    }

    public int getTotal() {
      return total;
    }

    public void setTotal(int total) {
      this.total = total;
    }

    public int getTotal_pages() {
      return total_pages;
    }

    public void setTotal_pages(int total_pages) {
      this.total_pages = total_pages;
    }

    public List<Data> getData() {
      return data;
    }

    public void setData(List<Data> data) {
      this.data = data;
    }
  }

  public static class Data {
    String Title;
    int Year;
    String imdbID;

    public String getTitle() {
      return Title;
    }

    public void setTitle(String title) {
      Title = title;
    }

    public int getYear() {
      return Year;
    }

    public void setYear(int year) {
      Year = year;
    }

    public String getImdbID() {
      return imdbID;
    }

    public void setImdbID(String imdbID) {
      this.imdbID = imdbID;
    }
  }

  static String[] getMovieTitles(String substr) {
    try {
      boolean process = true;
      int pageNumber = 1;
      List<String> list = new ArrayList<>();
      while (process) {
        URL url =
            new URL(
                "https://jsonmock.hackerrank.com/api/movies/search/?Title="
                    + substr
                    + "&page="
                    + pageNumber);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/json");
        InputStreamReader in = new InputStreamReader(connection.getInputStream());
        BufferedReader br = new BufferedReader(in);
        Gson gson = new Gson(); // Or use new GsonBuilder().create();
        Page page = gson.fromJson(br, Page.class);
        connection.disconnect();
        List<Data> dataList = page.getData();
        for (Data data : dataList) {
          list.add(data.getTitle());
        }
        if (page.getTotal() == list.size()) {
          process = false;
        } else {
          pageNumber++;
        }
      }
      list.sort(Comparator.naturalOrder());
      return list.toArray(new String[0]);
    } catch (Exception e) {
      System.out.println(e);
    }
    return new String[0];
  }

  public static void main(String[] args) throws IOException {
    System.out.println(getMovieTitles("spiderman"));
  }
}
