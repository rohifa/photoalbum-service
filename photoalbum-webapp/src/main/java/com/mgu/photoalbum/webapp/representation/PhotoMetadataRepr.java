package com.mgu.photoalbum.webapp.representation;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PhotoMetadataRepr {

    public static class PhotoMetadataReprBuilder {

        private MetaRepr meta = MetaRepr.create().build();
        private String photoId = StringUtils.EMPTY;
        private String description = StringUtils.EMPTY;
        private List<String> tags = new LinkedList<>();

        public PhotoMetadataReprBuilder meta(final MetaRepr meta) {
            this.meta = meta;
            return this;
        }

        public PhotoMetadataReprBuilder id(final String photoId) {
            this.photoId = photoId;
            return this;
        }

        public PhotoMetadataReprBuilder description(final String description) {
            this.description = description;
            return this;
        }

        public PhotoMetadataReprBuilder tag(final List<String> tags) {
            this.tags.addAll(tags);
            return this;
        }

        public PhotoMetadataRepr build() {
            return new PhotoMetadataRepr(this);
        }
    }

    @JsonProperty("_meta")
    private final MetaRepr meta;

    @JsonProperty("photoId")
    private final String photoId;

    @JsonProperty("description")
    private final String description;

    @JsonProperty("tags")
    private final List<String> tags;

    private PhotoMetadataRepr(final PhotoMetadataReprBuilder builder) {
        this.meta = builder.meta;
        this.photoId = builder.photoId;
        this.description = builder.description;
        this.tags = builder.tags;
    }

    public MetaRepr getMeta() {
        return this.meta;
    }

    public String getPhotoId() {
        return this.photoId;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public static PhotoMetadataReprBuilder create() {
        return new PhotoMetadataReprBuilder();
    }
}