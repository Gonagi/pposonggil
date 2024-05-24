package pposonggil.usedStuff.dto.ChatRoom;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pposonggil.usedStuff.domain.ChatRoom;
import pposonggil.usedStuff.dto.Message.MessageDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Data
@Builder
@NoArgsConstructor(access = PROTECTED)
@AllArgsConstructor(access = PRIVATE)
public class ChatRoomMessagesDto {
    private Long chatRoomId;
    private Long chatTradeId;
    private String addressName;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
    private List<MessageDto> messages;

    public static ChatRoomMessagesDto fromEntity(ChatRoom chatRoom) {
        return ChatRoomMessagesDto.builder()
                .chatRoomId(chatRoom.getId())
                .chatTradeId(chatRoom.getChatTrade().getId())
                .addressName(chatRoom.getChatTrade().getAddress().getName())
                .createdAt(chatRoom.getCreatedAt())
                .updateAt(chatRoom.getUpdateAt())
                .messages(chatRoom.getMessages().stream()
                        .map(MessageDto::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}