
package com.example.imagesapp.model;

import java.util.List;

public class Items
{
    private String snippet;

    private String htmlFormattedUrl;

    private String htmlTitle;

    private String kind;

    private Pagemap pagemap;

    private String displayLink;

    private String link;

    private String htmlSnippet;

    private String title;

    private String formattedUrl;

    public String getSnippet ()
    {
        return snippet;
    }

    public void setSnippet (String snippet)
    {
        this.snippet = snippet;
    }

    public String getHtmlFormattedUrl ()
    {
        return htmlFormattedUrl;
    }

    public void setHtmlFormattedUrl (String htmlFormattedUrl)
    {
        this.htmlFormattedUrl = htmlFormattedUrl;
    }

    public String getHtmlTitle ()
    {
        return htmlTitle;
    }

    public void setHtmlTitle (String htmlTitle)
    {
        this.htmlTitle = htmlTitle;
    }

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public Pagemap getPagemap ()
    {
        return pagemap;
    }

    public void setPagemap (Pagemap pagemap)
    {
        this.pagemap = pagemap;
    }

    public String getDisplayLink ()
    {
        return displayLink;
    }

    public void setDisplayLink (String displayLink)
    {
        this.displayLink = displayLink;
    }

    public String getLink ()
    {
        return link;
    }

    public void setLink (String link)
    {
        this.link = link;
    }

    public String getHtmlSnippet ()
    {
        return htmlSnippet;
    }

    public void setHtmlSnippet (String htmlSnippet)
    {
        this.htmlSnippet = htmlSnippet;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getFormattedUrl ()
    {
        return formattedUrl;
    }

    public void setFormattedUrl (String formattedUrl)
    {
        this.formattedUrl = formattedUrl;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [snippet = "+snippet+", htmlFormattedUrl = "+htmlFormattedUrl+", htmlTitle = "+htmlTitle+", kind = "+kind+", pagemap = "+pagemap+", displayLink = "+displayLink+", link = "+link+", htmlSnippet = "+htmlSnippet+", title = "+title+", formattedUrl = "+formattedUrl+"]";
    }
}

