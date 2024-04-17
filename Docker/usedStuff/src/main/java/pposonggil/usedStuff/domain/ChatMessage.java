package pposonggil.usedStuff.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.DynamicInsert;

import java.time.LocalDate;

import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@DynamicInsert
public class ChatMessage {
    @Id
    @GeneratedValue
    @Column(name = "chat_message_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumns({
            @JoinColumn(name = "chat_subject_id", referencedColumnName = "member_id"),
            @JoinColumn(name = "chat_room_id", referencedColumnName = "chat_room_id")
    })
    private MemberChatRoom memberChatRoom;

    @Column(length = 500)
    private String content;

    private boolean isRead;
    private LocalDate createdAt;
}
