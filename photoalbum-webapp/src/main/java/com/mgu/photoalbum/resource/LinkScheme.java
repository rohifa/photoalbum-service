package com.mgu.photoalbum.resource;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class LinkScheme {

    private static final String GALLERY_URI_TEMPLATE = "/albums";

    private static final String ALBUM_URI_TEMPLATE = "/albums/{albumId}";

    private static final String PHOTO_URI_TEMPLATE = "/albums/{albumId}/{photoId}";

    private static final String THUMBNAIL_URI_TEMPLATE = "/albums/{albumId}/{photoId}/thumbnail";

    private static final String METADATA_URI_TEMPLATE = "/albums/{albumId}/{photoId}/metadata";

    public URI toGallery() {
        return UriBuilder
                .fromUri(GALLERY_URI_TEMPLATE)
                .build();
    }

    public URI toAlbum(final String albumId) {
        return UriBuilder
                .fromUri(ALBUM_URI_TEMPLATE)
                .resolveTemplate("albumId", albumId)
                .build();
    }

    public URI toPhoto(final String albumId, final String photoId) {
        return withAlbumAndPhoto(albumId, photoId, PHOTO_URI_TEMPLATE);
    }

    public URI toThumbnail(final String albumId, final String photoId) {
        return withAlbumAndPhoto(albumId, photoId, THUMBNAIL_URI_TEMPLATE);
    }

    public URI toMetadata(final String albumId, final String photoId) {
        return withAlbumAndPhoto(albumId, photoId, METADATA_URI_TEMPLATE);
    }

    private URI withAlbumAndPhoto(final String albumId, final String photoId, final String template) {
        return UriBuilder
                .fromUri(template)
                .resolveTemplate("albumId", albumId)
                .resolveTemplate("photoId", photoId)
                .build();
    }

    public URI toDownload(final String albumId, final String photoId) {
        return UriBuilder
                .fromUri(PHOTO_URI_TEMPLATE)
                .resolveTemplate("albumId", albumId)
                .resolveTemplate("photoId", photoId)
                .queryParam("download", "true")
                .build();

    }

    public static void main(String[] args) {
        LinkScheme linkScheme = new LinkScheme();
        System.out.println(linkScheme.toGallery().toString());
    }
}