
package com.example.imagesapp.model;

import java.util.List;

public class ImagesResponse
{
    private String kind;

    private Context context;

    private Queries queries;

    private SearchInformation searchInformation;

    private Items[] items;

    private Url url;

    public String getKind ()
    {
        return kind;
    }

    public void setKind (String kind)
    {
        this.kind = kind;
    }

    public Context getContext ()
    {
        return context;
    }

    public void setContext (Context context)
    {
        this.context = context;
    }

    public Queries getQueries ()
    {
        return queries;
    }

    public void setQueries (Queries queries)
    {
        this.queries = queries;
    }

    public SearchInformation getSearchInformation ()
    {
        return searchInformation;
    }

    public void setSearchInformation (SearchInformation searchInformation)
    {
        this.searchInformation = searchInformation;
    }

    public Items[] getItems ()
    {
        return items;
    }

    public void setItems (Items[] items)
    {
        this.items = items;
    }

    public Url getUrl ()
    {
        return url;
    }

    public void setUrl (Url url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [kind = "+kind+", context = "+context+", queries = "+queries+", searchInformation = "+searchInformation+", items = "+items+", url = "+url+"]";
    }
}

