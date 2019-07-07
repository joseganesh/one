package Java.jasperreports;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Java.dto.SalesDto;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
//import transport.model.FuelType;

public class JavaCallJasperReport  {
   
	public static void main(String[] args) throws JRException,
    ClassNotFoundException, SQLException, IOException {
		
		getrepswing("","",null);

	}
	
	
	public static void getrepswing(String reportfilename,String reportSrcFile,JRDataSource sss) throws IOException{
		
		/*List<SalesDto> aa = new ArrayList<SalesDto>();
		SalesDto bb = new SalesDto();
		bb.setName("aaa");
		bb.setContactNo("fff");
		bb.setAddress("gggggggggg");
		
		bb.setProductCode("aaa");
		bb.setQuantity("gggg");
		bb.setModel("dddd");
		bb.setRate("666");
		bb.setNwt("8888");
		aa.add(bb);
		
		SalesDto bbb = new SalesDto();
		bbb.setName("bbb");
		bbb.setContactNo("fff");
		bbb.setAddress("gggggggggg");
		
		bbb.setProductCode("bbb");
		bbb.setQuantity("gggg");
		bbb.setModel("dddd");
		bbb.setRate("666");
		bbb.setNwt("8888");
		aa.add(bbb);
		
		 bbb = new SalesDto();
		bbb.setName("bbb");
		bbb.setContactNo("fff");
		bbb.setAddress("gggggggggg");
		
		bbb.setProductCode("ccc");
		bbb.setQuantity("gggg");
		bbb.setModel("dddd");
		bbb.setRate("666");
		bbb.setNwt("8888");
		aa.add(bbb); */
		
	
	String filename = "D:/Report.pdf"; 
	FileOutputStream output = new FileOutputStream(filename);
	//JRDataSource sss = new JRBeanCollectionDataSource(aa);
		
	String fileeeee = "jewellery_Invoice.jrxml";
	//String fileeeee = "jewelleryCopy1.jrxml";
try {
JasperReport jasperReport =    JasperCompileManager.compileReport(JavaCallJasperReport.class.getResourceAsStream(fileeeee));
//URL uls =JavaCallJasperReport.class.getResource("CampusLynx.png");
//String path = uls.getFile().toString();
Connection conn = ConnectionUtils.getConnection();


Map<String, Object> parameters = new HashMap<String, Object>();
JasperPrint print =null;
	 JRDataSource JRdataSource =(JRDataSource) sss;
	 print = JasperFillManager.fillReport(jasperReport,
	        parameters, JRdataSource);


// Make sure the output directory exists.
/*File outDir = new File("D:/jasperoutput");
outDir.mkdirs();*/

// PDF Exportor.
JRPdfExporter exporter = new JRPdfExporter();

ExporterInput exporterInput = new SimpleExporterInput(print);
// ExporterInput
exporter.setExporterInput(exporterInput);

// ExporterOutput
OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(output);
//OutputStream  exporterOutp = new OutputStream() {
//	
//	@Override
//	public void write(int b) throws IOException {
//		// TODO Auto-generated method stub
//		
//	}
//};
// Output
exporter.setExporterOutput(exporterOutput);

//
SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
exporter.setConfiguration(configuration);
exporter.exportReport();

System.out.print("Done!");
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (JRException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}


	
	
	
	
	
	
		public static void getrep(OutputStream output,String reportfilename,HttpServletRequest request,HttpServletResponse resp){
//String reportSrcFile = "fueltyprmaster.jrxml";
 
// String reportSrcFile = "fueltyprmaster.jrxml";
//JavaCallJasperReport.class.

//ClassLoader classLoader = new JavaCallJasperReport().getClass().getResource(reportSrcFile);
//File file = new File(JavaCallJasperReport.class.getResource(reportSrcFile).getFile());
//// First, compile jrxml file.
//String content = new String(Files.readAllBytes(file.toPath()));
		//	List<FuelType> lis = (List<FuelType>) request.getAttribute("listUsers");
			

try {
	JasperReport jasperReport =    JasperCompileManager.compileReport(JavaCallJasperReport.class.getResourceAsStream(reportfilename));
	URL uls =JavaCallJasperReport.class.getResource("CampusLynx.png");
	String path = uls.getFile().toString();
	Connection conn = ConnectionUtils.getConnection();
	
	// Parameters for report
	Map<String, Object> parameters = new HashMap<String, Object>();
	parameters.put("path", path);
	parameters.put("generatedby", request.getSession().getAttribute("username"));


	
	
	JasperPrint print =null;
	if(request!=null &&  request.getAttribute("JRdataSource")!=null){
		 JRDataSource JRdataSource =(JRDataSource)request.getAttribute("JRdataSource");
		 print = JasperFillManager.fillReport(jasperReport,
		        parameters, JRdataSource);
	}else{
	
	 print = JasperFillManager.fillReport(jasperReport,
	        parameters, conn);
	}
	// Make sure the output directory exists.
	/*File outDir = new File("D:/jasperoutput");
	outDir.mkdirs();*/
	
	// PDF Exportor.
	JRPdfExporter exporter = new JRPdfExporter();
	
	ExporterInput exporterInput = new SimpleExporterInput(print);
	// ExporterInput
	exporter.setExporterInput(exporterInput);
	
	// ExporterOutput
OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(output);
//	OutputStream  exporterOutp = new OutputStream() {
//		
//		@Override
//		public void write(int b) throws IOException {
//			// TODO Auto-generated method stub
//			
//		}
//	};
	// Output
	exporter.setExporterOutput(exporterOutput);
	
	//
	SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
	exporter.setConfiguration(configuration);
	exporter.exportReport();
	
	System.out.print("Done!");
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (JRException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}

}