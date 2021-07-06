package aforo255.ms.test.pay.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@Entity
@Table(name="operations")
public class Operation  implements Serializable{
	
	private static final long serialVersionUID = 1L;	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_operation")
	private Integer id;
	
	@Column(name = "id_invoice")
	private Integer invoiceId;
	
	private double amount;
	
	@JsonSerialize(using = ToStringSerializer.class)
	@Column(name = "date_operation")
	private LocalDateTime dateOperation;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public LocalDateTime getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(LocalDateTime dateOperation) {
		this.dateOperation = dateOperation;
	}

	@Override
	public String toString() {
		return "Operation [id=" + id + ", invoiceId=" + invoiceId + ", amount=" + amount + ", dateOperation="
				+ dateOperation + "]";
	}
	
	
}
