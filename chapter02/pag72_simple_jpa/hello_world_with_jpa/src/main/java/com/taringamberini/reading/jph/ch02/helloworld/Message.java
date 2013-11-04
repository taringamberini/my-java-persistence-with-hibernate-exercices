package com.taringamberini.reading.jph.ch02.helloworld;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tarin Gamberini <www.taringamberini.com>
 */
@Entity
@Table(name = "MESSAGES")
public class Message implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;
    @Column(name = "MESSAGE_TEXT")
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE_ID")
    private Message nextMessage;

    public Message() {
    }

    public Message(String text) {
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Message getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(Message nextMessage) {
        this.nextMessage = nextMessage;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Message{" + "id=" + id + ", text=" + text + ", nextMessage=" + nextMessage + '}';
    }
}
