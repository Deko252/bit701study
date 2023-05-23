package boot.study.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
@Alias("PhotoDto")
public class GuestPhotoDto {
	private int photo_idx;
	private int guest_idx;
	private String photoname;
}
