package org.github.stream.stream.response;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCategoryResponse {
    @SerializedName("category_id")
    private String categoryId;

    @SerializedName("category_name")
    private String categoryName;

    @SerializedName("parent_id")
    private int parentId;


}
