package org.github.stream.stream.response;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class MovieResponse {
    @SerializedName("num")
    private Integer num;

    @SerializedName("name")
    private String name;

    @SerializedName("title")
    private String title;

    @SerializedName("year")
    private String year;

    @SerializedName("stream_type")
    private String streamType;

    @SerializedName("stream_id")
    private Integer streamId;

    @SerializedName("stream_icon")
    private String streamIcon;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("rating_5based")
    private Double rating5Based;

    @SerializedName("added")
    private String added;

    @SerializedName("plot")
    private String plot;

    @SerializedName("cast")
    private String cast;

    @SerializedName("director")
    private String director;

    @SerializedName("genre")
    private String genre;

    @SerializedName("release_date")
    private String releaseDate;

    @SerializedName("youtube_trailer")
    private String youtubeTrailer;

    @SerializedName("episode_run_time")
    private String episodeRunTime;

    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("category_ids")
    private List<Integer> categoryIds;

    @SerializedName("container_extension")
    private String containerExtension;

    @SerializedName("custom_sid")
    private String customSid;

    @SerializedName("direct_source")
    private String directSource;
}
