package shop.zeedeco.dto.board;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BoardDto {

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ViewBoardRes {
		private Integer boardSeq;
		private String title;
		private String content;
		private String remark;
		private String startDt;
		private String endDt;
		private String useYn;
		private String delYn;
		private LocalDateTime createdDt;
		private Integer createdNo;
		private LocalDateTime updatedDt;
		private Integer updatedNo;
		
		public ViewBoardRes(Map<String, Object> responseMap) {
			this.boardSeq			= (Integer) 	responseMap.get("boardSeq") 		== null ? null : (Integer) 	responseMap.get("boardSeq");
			this.title				= (String) 		responseMap.get("title") 		 	== null ? null : (String) 	responseMap.get("title");
			this.content			= (String) 		responseMap.get("content")  		== null ? null : (String) 	responseMap.get("content");
			this.remark				= (String) 		responseMap.get("remark")			== null ? null : (String) 	responseMap.get("remark");
			this.startDt			= (String) 		responseMap.get("startDt")			== null ? null : (String) 	responseMap.get("startDt");
			this.endDt				= (String) 		responseMap.get("endDt")			== null ? null : (String) 	responseMap.get("endDt");
			this.useYn				= (String) 		responseMap.get("useYn")			== null ? null : (String) 	responseMap.get("useYn");
			this.delYn				= (String) 		responseMap.get("delYn")			== null ? null : (String) 	responseMap.get("delYn");
			this.createdDt			= (LocalDateTime) 	responseMap.get("createdDt") 	== null ? null : (LocalDateTime) 	responseMap.get("createdDt");
			this.createdNo			= (Integer) 	responseMap.get("createdNo")		== null ? null : (Integer) 	responseMap.get("createdNo");
			this.updatedDt			= (LocalDateTime) 	responseMap.get("updatedDt") 	== null ? null : (LocalDateTime) 	responseMap.get("updatedDt");
			this.updatedNo			= (Integer) 	responseMap.get("updatedNo")		== null ? null : (Integer) 	responseMap.get("updatedNo");
		}
	}
	
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class ViewBoardsRes {
        private List<BoardDto.ViewBoardRes> boards;
        private Integer totalCount;

        public ViewBoardsRes(List<BoardDto.ViewBoardRes> boards, Integer totalCount) {
            this.boards 	= boards;
            this.totalCount = totalCount;
        }
    }
    
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ViewBoardReq {
		private int boardSeq;
		private String title;
		private String content;
		private String startDt;
		private String endDt;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String useYn;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}  
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class AddBoardReq {
		@NotEmpty(message = "�Խ��� ������ ����ֽ��ϴ�.")
		private String title;
		@NotEmpty(message = "�Խ��� ������ ����ֽ��ϴ�.")
		private String content;
		private String remark;
		private String startDt;
		private String endDt;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String useYn;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		@NotNull(message = "���� ������ȣ�� ����ֽ��ϴ�.")
		private int memberSeq;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}   
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SetBoardReq {
		@NotNull(message = "�Խ��� ������ȣ�� ����ֽ��ϴ�.")
		private int boardSeq;
		@NotEmpty(message = "�Խ��� ������ ����ֽ��ϴ�.")
		private String title;
		@NotEmpty(message = "�Խ��� ������ ����ֽ��ϴ�.")
		private String content;
		private String remark;
		private String startDt;
		private String endDt;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String useYn;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		@NotNull(message = "���� ������ȣ�� ����ֽ��ϴ�.")
		private int memberSeq;
		
        public Map<String, Object> toMap() throws Exception {
            return new ObjectMapper().convertValue(this, Map.class);
        }
	}  
}