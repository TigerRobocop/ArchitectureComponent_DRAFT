package com.tigerrobocop.liv.architecturecomponentsample.Model;

import android.arch.persistence.room.Entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Livia on 02/12/2017.
 */

@Entity
public class XKCD implements Serializable {

    public String month;
    public String num;
    public String link;
    public String year;
    public String news;
    public String safe_title;
    public String transcript;
    public String alt;
    public String img;
    public String title;
    public String day;

}
