package camping.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

import camping.model.Stay;

public class InvoicePdfView extends AbstractPdfView {
	
	@Override
	protected void buildPdfDocument(Map model, Document document,
		PdfWriter writer, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
		
		Stay stay = (Stay) model.get("stay");
				
		Chunk c = new Chunk("Cerisaie");
		document.add(new Paragraph(c));		
		document.add(new Paragraph("Route de la plage"));
		document.add(new Paragraph("33121 – CARCANS"));
		document.add(new Paragraph("Etoiles : **"));
		document.add(new Paragraph("Téléphone : 05 - 67-78-56-45"));
		document.add(new Paragraph("Fax : 05 - 67 - 78 - 34 - 25"));
		
		document.add(Chunk.NEWLINE);
		Font titleFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
		c = new Chunk("Facture d'un séjour", titleFont);
		document.add(new Paragraph(c));
		document.add(Chunk.NEWLINE);
		
		Paragraph p = new Paragraph();
		p.add(new Chunk("Numéro de facture : "));
		p.add(new Chunk("SE" + stay.getId()));
		p.add("                   ");
		p.add(new Chunk("Date : "));
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("dd/MM/yyyy");
		p.add(new Chunk(ft.format(date)));
		document.add(p);
		
		document.add(Chunk.NEWLINE);
		Font smallTitle = FontFactory.getFont(FontFactory.HELVETICA, 14, Font.BOLD);
		c = new Chunk("Client : " + stay.getClient().getName(), smallTitle);
		document.add(new Paragraph(c));
		
		Table table = new Table(2);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Numéro de séjour");
		table.addCell(Integer.toString(stay.getId()));
		table.addCell("Numéro d'emplacement");
		table.addCell(Integer.toString(stay.getLocation().getId()));
		table.addCell("Type d'emplacement");
		table.addCell(stay.getLocation().getTypeLocation().getLabel());
		document.add(table);
		
		document.add(Chunk.NEWLINE);
		c = new Chunk("* Séjour *", smallTitle);
		document.add(new Paragraph(c));
		
		table = new Table(4);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Date de début");
		table.addCell("Date de fin");
		table.addCell("Nombre personnes");
		table.addCell("Prix/jour/personne");		
		table.addCell(ft.format(stay.getStartDate()));
		table.addCell(ft.format(stay.getEndDate()));
		table.addCell(Integer.toString(stay.getNumberPersons()));
		table.addCell(Double.toString(stay.getLocation().getTypeLocation().getPrice()));
		document.add(table);
		
		long diff = stay.getEndDate().getTime() - stay.getStartDate().getTime();
	    long days = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) - 1;
	    double total = days * stay.getLocation().getTypeLocation().getPrice() * stay.getNumberPersons();
		
		table = new Table(2);
		table.setAlignment(Element.ALIGN_LEFT);
		table.addCell("Total à payer");
		table.addCell(total + " €");
		document.add(table);
		
		document.close();
	}

}
