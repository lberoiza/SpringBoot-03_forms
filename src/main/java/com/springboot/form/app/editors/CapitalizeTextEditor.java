package com.springboot.form.app.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.stereotype.Component;

@Component
public class CapitalizeTextEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    setValue(capitalizeEveryWord(text));
  }

  private String capitalizeEveryWord(String input) {
    StringBuilder sb = new StringBuilder();
    String[] words = input.trim().split(" ");

    for (String word : words) {
      if (!word.isEmpty()) {
        String firstLetter = word.substring(0, 1).toUpperCase();
        String restOfLetters = word.substring(1).toLowerCase();
        sb.append(firstLetter).append(restOfLetters).append(" ");
      }
    }

    return sb.toString().trim();
  }

}
