package com.mgu.photoalbum.service;

import com.mgu.photoalbum.exception.PhotoalbumException;

public class AlbumDoesNotExistException extends PhotoalbumException {

    private static final String ERROR_MESSAGE = "An album for the given album ID %s does not exist.";

    public AlbumDoesNotExistException(final String albumId) {
        super(String.format(ERROR_MESSAGE, albumId));
    }

    @Override
    public String getErrorCode() {
        return "A001";
    }
}