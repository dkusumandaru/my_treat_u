$(document).ready(function(){
	stop_loader();
	sentInvoice();

	function sentInvoice(){
		var dataInvoice = $('#nota').html();
		var accessInvoice = 'owner';
		var idUser = $('#idUser').val();
		var idMember = $('#idMember').val();
		var idTransaction = $('#idTransaction').val();
		var accessUrl = base_url+'/transaction/sent_invoice/'+idUser+'/'+idMember+'/'+idTransaction;

		if (accessUrl != '') {
			run_loader();

			$.ajax({
				type: 'POST',
				url   : accessUrl,
				dataType : 'JSON',
				data :{accessInvoice: accessInvoice, dataInvoice: dataInvoice},
				success : function(data){
					stop_loader();
					if (data != false) {
						alert('Invoice Terkirim ke Owner...');
					}else{
						alert('Invoice Gagal dikirim!!!');
					}
				}	 
			});
		}
	}
});

function sentNumber(){
	var number = $('#number').val();
	var app = $('#apps').val();
	var payment = $('#payment').val();
	var idMember = $('#idMember').val();
	var idTransaction = $('#idTransaction').val();
	var accessUrl = base_url+'/invoice/public/'+idMember+'/'+idTransaction;

	var it1 = accessUrl.replace(":", '%3A');
	var it2 = it1.replace("/", '%2F');
	
	var itn0 = number.slice(0, 1);
	if(itn0 == '62'){
        var sentNumber = '62'+number; 
    }else{
        var itn1 = number.slice(1, number.length);
        var sentNumber = '62'+itn1;
    }

	var message1 = 'Thanks%20for%20shopping%20with%20';
	var message2 = '.%0A%20Total%20purchased%3A%20';
	var message3 = '.%0AView%20receipt%20';

	var message = message1+app+message2+currencyFormater(payment)+message3+it2;

	var destination = '<a class="btn btn-info col-12" href="https://wa.me/'+sentNumber+'?text='+message+'"><span class="fab fa-whatsapp"></span> Kirim</a>'

	$('#sent').html(destination);
}

function clearNumber(){
	$('#number').val('');
}

