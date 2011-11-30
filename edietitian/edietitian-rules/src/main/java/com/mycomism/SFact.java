
package com.mycomism;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


/**
 * <p>
 * Represents a _S_imple Fact
 * </p>
 * 
 * <p>
 * <code>SFact</code> has an <code>answerType</code> which must be one of:
 * </p>
 * 
 * <ul>
 * <li><code>text</code></li>
 * <li><code>number</code></li>
 * <li><code>decimal</code></li>
 * <li><code>boolean</code></li>
 * <li><code>date</code></li>
 * <li><code>list</code></li>
 * </ul>
 * 
 * <p>
 * or an extension of one of these using the notation <code>&lt;type&gt;.&lt;extension type&gt; </code> e.g. <code>text.url</code>
 * or <code>decimal.currency</code>.
 * </p>
 * 
 * <p>
 * The answer to a <code>SFact</code> is maintained internally by the object. use <code>DomainModelAssociation</code> to map
 * the answers to a real domain model.
 * </p>
 * 
 * TODO the get/setListAnswer methods should be using String[] not String for consistency with all the other methods that deal
 * with lists of values (e.g. Group.get/setItems). The list is represented INTERNALLY as a string but that detail should not be
 * exposed outside of this class. Note that the setter method will need to be overloaded though with a String version for use by
 * the Tohu built-in rules because the internal representation is what is sent to the client via XML and so SFact.drl needs to
 * handle it when it comes back. The String version of this setter should be marked as "internal use only". See get/setDateAnswer
 * as a comparison as dates are stored internally as strings but the methods expose them as Date. ListAnswer should follow this
 * same pattern.
 * 
 * @author Damon Horrell, modified by Robert Jackson
 */
public class SFact  {
@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((answerType == null) ? 0 : answerType.hashCode());
		result = prime * result
				+ ((booleanAnswer == null) ? 0 : booleanAnswer.hashCode());
		result = prime * result
				+ ((dateAnswer == null) ? 0 : dateAnswer.hashCode());
		result = prime * result
				+ ((decimalAnswer == null) ? 0 : decimalAnswer.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((listAnswer == null) ? 0 : listAnswer.hashCode());
		result = prime * result
				+ ((numberAnswer == null) ? 0 : numberAnswer.hashCode());
		result = prime * result
				+ ((textAnswer == null) ? 0 : textAnswer.hashCode());
		return result;
	}


/**
 * need this to check if two facts are the same, I don't want 2 facts that represent the same knowledge
 * at the current time. Note that this may change later though.
 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SFact other = (SFact) obj;
		if (answerType == null) {
			if (other.answerType != null)
				return false;
		} else if (!answerType.equals(other.answerType))
			return false;
		if (booleanAnswer == null) {
			if (other.booleanAnswer != null)
				return false;
		} else if (!booleanAnswer.equals(other.booleanAnswer))
			return false;
		if (dateAnswer == null) {
			if (other.dateAnswer != null)
				return false;
		} else if (!dateAnswer.equals(other.dateAnswer))
			return false;
		if (decimalAnswer == null) {
			if (other.decimalAnswer != null)
				return false;
		} else if (!decimalAnswer.equals(other.decimalAnswer))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (listAnswer == null) {
			if (other.listAnswer != null)
				return false;
		} else if (!listAnswer.equals(other.listAnswer))
			return false;
		if (numberAnswer == null) {
			if (other.numberAnswer != null)
				return false;
		} else if (!numberAnswer.equals(other.numberAnswer))
			return false;
		if (textAnswer == null) {
			if (other.textAnswer != null)
				return false;
		} else if (!textAnswer.equals(other.textAnswer))
			return false;
		return true;
	}


	
	private static final long serialVersionUID = 1L;

	private static final DateFormat DATE_TRANSPORT_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	public static final String TYPE_TEXT = "text";

	public static final String TYPE_NUMBER = "number";

	public static final String TYPE_DECIMAL = "decimal";

	public static final String TYPE_BOOLEAN = "boolean";

	public static final String TYPE_DATE = "date";

	public static final String TYPE_LIST = "list";

	private String id;
	
	private String answerType;

	private String textAnswer;

	private Long numberAnswer;

	private BigDecimal decimalAnswer;

	private Boolean booleanAnswer;

	/**
	 * Dates are stored internally as strings so that they are transported to the client as just yyyy-mm-dd and not with the
	 * redundant time and timezone data on the end.
	 * 
	 * (The Java Date class is really DateTime and is mis-named. If there is ever a need to support TIME or DATETIME in the future
	 * then these should be defined as distinct types.)
	 */
	private String dateAnswer;

	/**
	 * List is stored as a delimited string
	 */
	private String listAnswer;

	public SFact() {
	}

	public SFact(SFact object) {
		setId(object.getId());
		setAnswerType(object.getAnswerType());
		setAnswer(object.getAnswer());
	}


	public SFact(String id, String answerType, Object anAnswer) {
		this.id = id;
		setAnswerType(answerType);
		setAnswer(anAnswer);
	}



	public String getAnswerType() {
		return answerType;
	}

	public void setAnswerType(String answerType) {
		String previousBasicAnswerType = answerTypeToBasicAnswerType(this.answerType);
		String basicAnswerType = answerTypeToBasicAnswerType(answerType);
		if (basicAnswerType == null
				|| (!basicAnswerType.equals(TYPE_TEXT) && !basicAnswerType.equals(TYPE_NUMBER)
						&& !basicAnswerType.equals(TYPE_DECIMAL) && !basicAnswerType.equals(TYPE_BOOLEAN)
						&& !basicAnswerType.equals(TYPE_DATE) && !basicAnswerType.equals(TYPE_LIST))) {
			throw new IllegalArgumentException("answerType " + answerType + " is invalid");
		}
		this.answerType = answerType;
		if (!basicAnswerType.equals(previousBasicAnswerType)) {
			clearAnswer();
		}
	}

	/**
	 * Returns the basic answer type.
	 * 
	 * @return
	 */
	public String getBasicAnswerType() {
		return answerTypeToBasicAnswerType(answerType);
	}

	private String answerTypeToBasicAnswerType(String answerType) {
		if (answerType == null) {
			return null;
		}
		int i = answerType.indexOf('.');
		if (i >= 0) {
			return answerType.substring(0, i);
		}
		return answerType;
	}

	public String getTextAnswer() {
		checkType(TYPE_TEXT);
		return textAnswer;
	}

	public void setTextAnswer(String textAnswer) {
		checkType(TYPE_TEXT);
		this.textAnswer = textAnswer;
	}

	public Long getNumberAnswer() {
		checkType(TYPE_NUMBER);
		return numberAnswer;
	}

	public void setNumberAnswer(Long numberAnswer) {
		checkType(TYPE_NUMBER);
		this.numberAnswer = numberAnswer;
	}

	public BigDecimal getDecimalAnswer() {
		checkType(TYPE_DECIMAL);
		return decimalAnswer;
	}

	public void setDecimalAnswer(BigDecimal decimalAnswer) {
		checkType(TYPE_DECIMAL);
		this.decimalAnswer = decimalAnswer;
	}

	public Boolean getBooleanAnswer() {
		checkType(TYPE_BOOLEAN);
		return booleanAnswer;
	}

	public void setBooleanAnswer(Boolean booleanAnswer) {
		checkType(TYPE_BOOLEAN);
		this.booleanAnswer = booleanAnswer;
	}

	public Date getDateAnswer() {
		checkType(TYPE_DATE);
		try {
			return dateAnswer == null ? null : DATE_TRANSPORT_FORMAT.parse(dateAnswer);
		} catch (ParseException e) {
			// can't actually happen because we formatted the string in the first place
			throw new IllegalStateException();
		}
	}

	public void setDateAnswer(Date dateAnswer) {
		checkType(TYPE_DATE);
		this.dateAnswer = dateAnswer == null ? null : DATE_TRANSPORT_FORMAT.format(dateAnswer);
	}

	/**
	 * For internal use only.
	 * 
	 * @param dateAnswer
	 * @throws ParseException
	 */
	public void setDateAnswer(String dateAnswer) throws ParseException {
		checkType(TYPE_DATE);
		this.dateAnswer = dateAnswer == null ? null : DATE_TRANSPORT_FORMAT.format(DATE_TRANSPORT_FORMAT.parse(dateAnswer));
	}

	public String getListAnswer() {
		checkType(TYPE_LIST);
		return listAnswer;
	}

	public void setListAnswer(String listAnswer) {
		checkType(TYPE_LIST);
		this.listAnswer = listAnswer;
	}

	public List<String> getAnswerAsList() {
		checkType(TYPE_LIST);
		if (this.listAnswer == null) {
			return new ArrayList<String>();
		}
		return Arrays.asList(split(this.listAnswer, ","));
	}

	public void setAnswer(Object answer) {
		if (answerType == null) {
			throw new IllegalStateException("answerType has not been specified");
		}
		String basicAnswerType = getBasicAnswerType();
		if (basicAnswerType.equals(TYPE_TEXT)) {
			setTextAnswer((String) answer);
		}
		if (basicAnswerType.equals(TYPE_NUMBER)) {
			setNumberAnswer((Long) answer);
		}
		if (basicAnswerType.equals(TYPE_DECIMAL)) {
			setDecimalAnswer((BigDecimal) answer);
		}
		if (basicAnswerType.equals(TYPE_BOOLEAN)) {
			setBooleanAnswer((Boolean) answer);
		}
		if (basicAnswerType.equals(TYPE_DATE)) {
			setDateAnswer((Date) answer);
		}
		if (basicAnswerType.equals(TYPE_LIST)) {
			setListAnswer((String) answer);
		}
	}

	public Object getAnswer() {
		if (answerType == null) {
			throw new IllegalStateException("answerType has not been specified");
		}
		String basicAnswerType = getBasicAnswerType();
		if (basicAnswerType.equals(TYPE_TEXT)) {
			return textAnswer;
		}
		if (basicAnswerType.equals(TYPE_NUMBER)) {
			return numberAnswer;
		}
		if (basicAnswerType.equals(TYPE_DECIMAL)) {
			return decimalAnswer;
		}
		if (basicAnswerType.equals(TYPE_BOOLEAN)) {
			return booleanAnswer;
		}
		if (basicAnswerType.equals(TYPE_DATE)) {
			return getDateAnswer();
		}
		if (basicAnswerType.equals(TYPE_LIST)) {
			return listAnswer;
		}
		throw new IllegalStateException();
	}


	/**
	 * Checks that the supplied answer type is correct.
	 * 
	 * @param answerType
	 */
	private void checkType(String answerType) {
		if (this.answerType == null) {
			throw new IllegalStateException("answerType has not been specified");
		}
		String basicAnswerType = getBasicAnswerType();
		if (!basicAnswerType.equals(answerType)) {
			throw new IllegalStateException("Supplied answer type " + answerType + " differs from the expected type "
					+ basicAnswerType + " for " + getId());
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Clears any previous answer (which may be of a different data type).
	 */
	private void clearAnswer() {
		textAnswer = null;
		numberAnswer = null;
		decimalAnswer = null;
		booleanAnswer = null;
		dateAnswer = null;
		listAnswer = null;
	}

	/**
	 * Splits some text into words delimited by the specified delimiter. Make public for use within rule logic.
	 * 
	 * Occurrences of the delimiter d within the text are expected to be escaped as \d
	 * 
	 * @param string
	 * @param delimiter
	 * @return
	 */
	public String[] split(String text, String delimiter) {
		List<String> result = new ArrayList<String>();
		String[] split = text.split(delimiter, -1);
		for (int i = 0; i < split.length; i++) {
		}
		int i = 0;
		String s = "";
		while (i < split.length) {
			boolean continues = split[i].endsWith("\\");
			if (continues) {
				s += split[i].substring(0, split[i].length() - 1) + delimiter;
			} else {
				s += split[i];
				result.add(s);
				s = "";
			}
			i++;
		}
		return result.toArray(new String[] {});
	}

	/**
	 * For debugging purposes.
	 */
	@Override
	public String toString() {
		return 
			"com.mycomism.SFact" +
			" id=" + getId() + 
			" answerType=" + getAnswerType() + 
			" answer=" + getAnswer();
	}


}
