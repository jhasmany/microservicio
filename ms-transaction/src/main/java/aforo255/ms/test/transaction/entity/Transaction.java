package aforo255.ms.test.transaction.entity;

import java.time.LocalDate;

import org.bson.codecs.pojo.annotations.BsonId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import org.springframework.data.annotation.Transient;

@Document(collection = "transactions")
public class Transaction {
	
	@Transient
    public static final String SEQUENCE_NAME = "transaction_sequence";
	
	@BsonId
	private String transactionId ; 
	
	private Integer invoiceId;
	
	private double amount;
	
	@JsonSerialize(using = ToStringSerializer.class)
	private LocalDate dateTransaction;

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Integer getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public LocalDate getDateTransaction() {
		return dateTransaction;
	}

	public void setDateTransaction(LocalDate dateTransaction) {
		this.dateTransaction = dateTransaction;
	}
}
