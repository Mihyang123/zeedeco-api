package shop.zeedeco.dto.product;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class ReservationDto {
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class AddReservation {
		@NotNull(message = "��ǰ �� ������ȣ�� �����ϴ�.")
		private Integer productDetailSeq;
		@NotEmpty(message = "���� ������ �����ϴ�.")
		private String comment;
		private String remark;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String cancelYn;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		@NotNull(message = "���� ������ȣ�� �����ϴ�.")
		private Integer memberSeq;
		
		public Map<String, Object> toMap() throws Exception {
			return new ObjectMapper().convertValue(this, Map.class);
		}
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SetReservation {
		@NotNull(message = "���� ������ȣ�� �����ϴ�.")
		private Integer reservationSeq;
		@NotEmpty(message = "���� ������ �����ϴ�.")
		private String comment;
		private String remark;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String cancelYn;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		@NotNull(message = "���� ������ȣ�� �����ϴ�.")
		private Integer memberSeq;
		
		public Map<String, Object> toMap() throws Exception {
			return new ObjectMapper().convertValue(this, Map.class);
		}
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class SetReservationByDelYn {
		@NotNull(message = "���� ������ȣ�� �����ϴ�.")
		private Integer reservationSeq;
		@Pattern(regexp = "^(Y|N)$", message = "'Y' �Ǵ� 'N' �� �ԷµǾ�� �մϴ�.")
		private String delYn;
		@NotNull(message = "���� ������ȣ�� �����ϴ�.")
		private Integer memberSeq;
		
		public Map<String, Object> toMap() throws Exception {
			return new ObjectMapper().convertValue(this, Map.class);
		}
	}
}
