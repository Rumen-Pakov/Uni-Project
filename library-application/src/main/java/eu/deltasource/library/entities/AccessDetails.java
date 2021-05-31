package eu.deltasource.library.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contains urls for access of {@link EBookInfo} online.
 */
@Getter
@Setter
@NoArgsConstructor
public class AccessDetails {

    private String readOnlineUrl;
    private String downloadUrl;

    public AccessDetails(String readOnlineUrl, String downloadUrl) {
        setReadOnlineUrl(readOnlineUrl);
        setDownloadUrl(downloadUrl);
    }

    public boolean hasDownloadUrl() {
        return downloadUrl != null;
    }

    public void setDownloadUrl(String downloadUrl) {
        if (downloadUrl != null) {
            downloadUrl = downloadUrl.trim();
        }
        this.downloadUrl = downloadUrl;
    }
}
