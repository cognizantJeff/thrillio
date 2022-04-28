package com.cognizant.thrillio.dao;

import com.cognizant.thrillio.DataStore;
import com.cognizant.thrillio.entities.Book;
import com.cognizant.thrillio.entities.Bookmark;
import com.cognizant.thrillio.entities.UserBookmark;
import com.cognizant.thrillio.entities.WebLink;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cognizant
 */
public class BookmarkDao {
    public List<List<Bookmark>> getBookmarks() {
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }

    public List<WebLink> getAllWebLinks() {
        List<WebLink> result = new ArrayList<>();
        List<List<Bookmark>> bookmarks = DataStore.getBookmarks();
        List<Bookmark> allWebLinks = bookmarks.get(0);//0th index is weblinks, followed by books and movies

        for(Bookmark bookmark : allWebLinks) {
            result.add((WebLink)bookmark);
        }

        return result;
    }

    public List<WebLink> getWebLinks(WebLink.DownloadStatus downloadStatus) {
        List<WebLink> result = new ArrayList<>();
        List<WebLink> allWebLinks = getAllWebLinks();

        for(WebLink webLink : allWebLinks){
            if(webLink.getDownloadStatus().equals(downloadStatus) ) {
                result.add(webLink);
            }
        }

        return result;
    }
}
