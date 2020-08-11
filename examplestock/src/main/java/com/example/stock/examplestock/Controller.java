package com.example.stock.examplestock;

/*import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;*/
//import java.util.Iterator;
import java.util.List;
/*import java.util.Map;
import java.util.Date;
import java.util.List;*/
import java.util.Optional;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DateUtil;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.web.JsonPath;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/*import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.request.WebRequest;*/
//import org.springframework.web.multipart.MultipartFile;


//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.stock.examplestock.Repository.CompanyRepository;
import com.example.stock.examplestock.Repository.ExchangeRepository;
import com.example.stock.examplestock.Repository.IpoRepository;
import com.example.stock.examplestock.Repository.SectorRepository;
import com.example.stock.examplestock.Repository.StockRepository;
import com.example.stock.examplestock.Repository.UserRepository;




@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path="/api")
public class Controller {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private StockRepository stockRepository;
	@Autowired
	private IpoRepository ipoRepository;
	@Autowired
	private SectorRepository sectorRepository;
	@Autowired
	private ExchangeRepository exchangeRepository;
	public int filenum=0;
	
	@PostMapping("/users/checkadmin")
	  public @ResponseBody String adminLogin(@RequestBody UserSample user) {
		  UserSample admin = userRepository.getByEmailAndPassword(user.getEmail(),user.getPassword());
		  if(admin!=null && admin.getType().equals("admin")) {
			  return "sucess";
		  }
		  else {
			  return "failed";
		  }
		  
	  }
	  
	/*  @PostMapping("/file")
	  public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
	     String message="";
	     try {
	        try {
	        	//FileInputStream fis = new FileInputStream(file);
	        	XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream()); 
	        	XSSFSheet sheet = wb.getSheetAt(0);
	        	Iterator<Row> itr = sheet.iterator();
	        	Row r1 = itr.next();
	        	while (itr.hasNext() )                 
	        	{ 
	        	Stock s1=new Stock();
	        	Row row = itr.next();
	        	Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
	        	//while (cellIterator.hasNext())   
	        	//{ 
	        	    Cell cell = cellIterator.next();  
	        		s1.setC_code(cell.getStringCellValue());
	        		Cell cell1 = cellIterator.next();
	        		s1.setS_exc(cell1.getStringCellValue());
	        		Cell cell2 = cellIterator.next();
	        		s1.setC_price((int) cell2.getNumericCellValue());
	        		Cell cell3 = cellIterator.next();
	        		//java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
	        		s1.setS_date(cell3.getDateCellValue() );
	        		//java.util.Date date = cell.getDateCellValue();
	        		//java.sql.Date sqlDate = new java.sql.Date(date);
//	        		java.sql.Date sqlDate = new java.sql.Date( cell3.getDateCellValue() );
//	        		s1.setDate(cell3.getDateCellValue());
//	       		    Cell cell4 = cellIterator.next();
//	        		s1.setTime(cell4.getStringCellValue());
//	        		
	        	stockRepository.save(s1);
	        	}
	        }
	        	catch(Exception e)  
	        	{  
	        	e.printStackTrace();
	        } 
	        return ResponseEntity.status(HttpStatus.OK).body(message);
	     } catch (Exception e) {
	        message = "Failed to upload!";
	        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
	     }
	  }*/
	  @GetMapping(path="/bytype/{type}")
	  public @ResponseBody List<String> getByuser(@PathVariable String type ) {
	    return userRepository.findBytype(type);
	  }
	@PostMapping(path="/users/add") 
	public @ResponseBody String addNewUser (@RequestBody UserSample user) {
		user.setConfirmation(1);
		    userRepository.save(user);
		    return "Saved";
		  }
	@PostMapping(path="/company/add") 
	public @ResponseBody String addNewCompany (@RequestBody CompanySample company) {
		    companyRepository.save(company);
		    return "Saved";
		  }
	
	@PostMapping(path="/stock/add") 
	public @ResponseBody String addNewStock (@RequestBody Stock stock) {
		    stockRepository.save(stock);
		    return "Saved";
		  }
	@PostMapping(path="/ipo/add") 
	public @ResponseBody String addNewIpo (@RequestBody Ipo ipo) {
		    ipoRepository.save(ipo);
		    return "Saved";
		  }
	@PostMapping(path="/sector/add") 
	public @ResponseBody String addNewSector (@RequestBody Sector sector) {
		    sectorRepository.save(sector);
		    return "Saved";
		  }
	@PostMapping(path="/exchange/add") 
	public @ResponseBody String addNewExchange (@RequestBody Exchange exchange) {
		    exchangeRepository.save(exchange);
		    return "Saved";
		  }
	  @GetMapping(path="/users")
	  public @ResponseBody List<UserSample> getAllUsers() {
		    return (List<UserSample>) userRepository.findAll();
	  }
	  @GetMapping(path="/company")
	  public @ResponseBody Iterable<CompanySample> getAllCompany() {
		    return companyRepository.findAll();
	  }
	  @GetMapping(path="/stock")
	  public @ResponseBody Iterable<Stock> getAllStock() {
		    return stockRepository.findAll();
	  }
	  @GetMapping(path="/ipo")
	  public @ResponseBody Iterable<Ipo> getAllIpo() {
		    return ipoRepository.findAll();
	  }
	  @GetMapping(path="/sector")
	  public @ResponseBody Iterable<Sector> getAllSector() {
		    return sectorRepository.findAll();
	  }
	  @GetMapping(path="/exchange")
	  public @ResponseBody Iterable<Exchange> getAllExchange() {
		    return exchangeRepository.findAll();
	  }
	  
	  @GetMapping(path="/users/byid/{id}")
	  public @ResponseBody UserSample getById(@PathVariable Integer id) {
		    return userRepository.findById(id).get();
		  }
	  @GetMapping(path="/company/byid/{id}")
	  public @ResponseBody CompanySample getByCompanyId(@PathVariable Integer id) {
		    return companyRepository.findById(id).get();
		  }
	  @GetMapping(path="/stock/byid/{id}")
	  public @ResponseBody Stock getByStockId(@PathVariable Integer id) {
		    return stockRepository.findById(id).get();
		  }
	  @GetMapping(path="/ipo/byid/{id}")
	  public @ResponseBody Ipo getByIpoId(@PathVariable Integer id) {
		    return ipoRepository.findById(id).get();
		  }
	  @GetMapping(path="/sector/byid/{id}")
	  public @ResponseBody Sector getBySectorId(@PathVariable Integer id) {
		    return sectorRepository.findById(id).get();
		  }
	  @GetMapping(path="/exchange/byid/{id}")
	  public @ResponseBody Exchange getByExchangeId(@PathVariable Integer id) {
		    return exchangeRepository.findById(id).get();
		  }
	  @DeleteMapping(path="/users/cancel/byid/{id}")
	  public List<UserSample> cancelAdminByID(@PathVariable Integer id) {
		  userRepository.deleteById(id);
		  return (List<UserSample>) userRepository.findAll();
	  }
	  @DeleteMapping(path="/company/cancel/byid/{id}")
	  public List<CompanySample> cancelCompanyByID(@PathVariable Integer id) {
		  companyRepository.deleteById(id);
		  return (List<CompanySample>) companyRepository.findAll();
	  }
	  @DeleteMapping(path="/stock/cancel/byid/{id}")
	  public List<Stock> cancelStockByID(@PathVariable Integer id) {
		  stockRepository.deleteById(id);
		  return (List<Stock>) stockRepository.findAll();
	  }
	  @DeleteMapping(path="/ipo/cancel/byid/{id}")
	  public List<Ipo> cancelIpoByID(@PathVariable Integer id) {
		  ipoRepository.deleteById(id);
		  return (List<Ipo>) ipoRepository.findAll();
	  }
	  @DeleteMapping(path="/sector/cancel/byid/{id}")
	  public List<Sector> cancelSectorByID(@PathVariable Integer id) {
		  sectorRepository.deleteById(id);
		  return (List<Sector>) sectorRepository.findAll();
	  }
	  @DeleteMapping(path="/exchange/cancel/byid/{id}")
	  public List<Exchange> cancelExchangeByID(@PathVariable Integer id) {
		  exchangeRepository.deleteById(id);
		  return (List<Exchange>) exchangeRepository.findAll();
	  }
	  @PutMapping(path="/users/update/byid/{id}")
	  public ResponseEntity<Object> updateUsers(@RequestBody UserSample user, @PathVariable Integer id){
		  Optional<UserSample> userOptional = userRepository.findById(id);
			if (!userOptional.isPresent())
				return ResponseEntity.notFound().build();
			user.setConfirmation(1);
			user.setId(id);
			userRepository.save(user);
			return ResponseEntity.noContent().build(); 
	  }
	  @PutMapping(path="/company/update/byid/{id}")
	  public ResponseEntity<Object> updateCompany(@RequestBody CompanySample company, @PathVariable Integer id){
		  Optional<CompanySample> companyOptional = companyRepository.findById(id);
			if (!companyOptional.isPresent())
				return ResponseEntity.notFound().build();
			company.setId(id);
			companyRepository.save(company);
			return ResponseEntity.noContent().build(); 
	  }
	/*  @PutMapping(path="/stock/update/byid/{id}")
	  public ResponseEntity<Object> updateStock(@RequestBody Stock stock, @PathVariable Integer id){
		  Optional<Stock> stockOptional = stockRepository.findById(id);
			if (!stockOptional.isPresent())
				return ResponseEntity.notFound().build();
			stock.setId(id);
			stockRepository.save(stock);
			return ResponseEntity.noContent().build(); 
	  }
	  @PutMapping(path="/ipo/update/byid/{id}")
	  public ResponseEntity<Object> updateIpo(@RequestBody Ipo ipo, @PathVariable Integer id){
		  Optional<Ipo> ipoOptional = ipoRepository.findById(id);
			if (!ipoOptional.isPresent())
				return ResponseEntity.notFound().build();
			ipo.setId(id);
			ipoRepository.save(ipo);
			return ResponseEntity.noContent().build(); 
	  }
	  @PutMapping(path="/sector/update/byid/{id}")
	  public ResponseEntity<Object> updateSector(@RequestBody Sector sector, @PathVariable Integer id){
		  Optional<Sector> sectorOptional = sectorRepository.findById(id);
			if (!sectorOptional.isPresent())
				return ResponseEntity.notFound().build();
			sector.setId(id);
			sectorRepository.save(sector);
			return ResponseEntity.noContent().build(); 
	  }
	  @PutMapping(path="/exchange/update/byid/{id}")
	  public ResponseEntity<Object> updateExchange(@RequestBody Exchange exchange, @PathVariable Integer id){
		  Optional<Exchange> exchangeOptional = exchangeRepository.findById(id);
			if (!exchangeOptional.isPresent())
				return ResponseEntity.notFound().build();
			exchange.setId(id);
			exchangeRepository.save(exchange);
			return ResponseEntity.noContent().build(); 
	  }*/

	  
	  @PutMapping(path="/company/update")          
	  public @ResponseBody String update(@RequestBody CompanySample updatecompany) {
	    
	    companyRepository.save(updatecompany);
	    return "Updated";
	  }
}
