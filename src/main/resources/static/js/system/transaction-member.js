//---<> Member
	var resultMembers = [];
	var defaultMember = [];
	var useMember = [];

	function executeSearchMember(){
		var accessSearch = 'searchMember';
		var accessUrl = base_url+'transaction/search_member';

		if (accessSearch != '') {

			var valueSearch = $('#searchMember').val();
			if (valueSearch != '') {
				$('#members').html('');

				$.ajax({
					type: 'POST',
					url   : accessUrl,
					dataType : 'JSON',
					data :{accessSearch: accessSearch, valueSearch: valueSearch},
					success : function(data){
						if (data != false) {
							var members = '';
							
							// 
							resultMembers.push(data);
							for (var i = 0; i < data.length; i++) {


								var idMember = data[i].id_member;
								var nameMember = data[i].name_member;
								var roleMember = data[i].role_member;
								var phoneMember = data[i].phone_member;
								if (idMember != '0000000000') {
									var memberFrameUsage = 
										memberFrame[0]+idMember+ //id_member'
										memberFrame[1]+
										// memberFrame[2]+
										memberFrame[3]+
										memberFrame[4]+
										memberFrame[5]+idMember+ //id_member
										memberFrame[6]+
										memberFrame[7]+nameMember+//Name
										memberFrame[8]+
										memberFrame[9]+phoneMember+//Phone
										memberFrame[10]+
										memberFrame[11]+
										memberFrame[12]+idMember+//id
										memberFrame[13]+
										memberFrame[14]+
										memberFrame[15];

									members += memberFrameUsage;
								}else{
									defaultMember.push(data[i]);
								}
							}

							$('#members').html(members);
							

						}else{
							var memberFrameUsage = 
								memberFrame[0]+
								memberFrame[2]+
								memberFrame[17]+valueSearch+
								memberFrame[18]+
								memberFrame[16]+							
								memberFrame[19]+
								memberFrame[20];

								members = memberFrameUsage;
							$('#members').html(members);
						}
					}
		 
				});
			}else{
				alert('Form Pencarian Kosong!!!');
			}
		}
	}

	function executeGetMember(){
		var accessSearch = 'searchMember';
		var accessUrl = base_url+'transaction/search_member';

		if (accessSearch != '') {

			var valueSearch = 'GET';
			if (valueSearch != '') {
				$('#members').html('');

				$.ajax({
					type: 'POST',
					url   : accessUrl,
					dataType : 'JSON',
					data :{accessSearch: accessSearch, valueSearch: valueSearch},
					success : function(data){
						if (data != false) {
							var members = '';
							
							resultMembers.push(data);
							for (var i = 0; i < data.length; i++) {
								var idMember = data[i].id_member;
								var nameMember = data[i].name_member;
								var roleMember = data[i].role_member;
								var phoneMember = data[i].phone_member;
								
								if (idMember != '0000000000') {
									var memberFrameUsage = 
										memberFrame[0]+idMember+ //id_member'
										memberFrame[1]+
										// memberFrame[2]+
										memberFrame[3]+
										memberFrame[4]+
										memberFrame[5]+idMember+ //id_member
										memberFrame[6]+
										memberFrame[7]+nameMember+//Name
										memberFrame[8]+
										memberFrame[9]+phoneMember+//Phone
										memberFrame[10]+
										memberFrame[11]+
										memberFrame[12]+idMember+//id
										memberFrame[13]+
										memberFrame[14]+
										memberFrame[15];

									members += memberFrameUsage;
								}else{
									defaultMember.push(data[i]);
								}

							}

							$('#members').html(members);
							

						}else{
							var memberFrameUsage = 
								memberFrame[0]+
								memberFrame[2]+
								memberFrame[16]+valueSearch+
								memberFrame[17]+
								memberFrame[15]+
								memberFrame[18]+
								
								memberFrame[14];
								members = memberFrameUsage;
							$('#members').html(members);
						}
					}
		 
				});
			}else{
				alert('Form Pencarian Kosong!!!');
			}
		}
	}

	function clearSearchMember(){
		useMember = [];
		defaultMember = [];
		$('#members').html('');
		$('#customer').remove('');
		$('#searchMember').val('');
		executeGetMember();

	}

	function unchooseMember(idMember){
		$('#member_box_'+idMember).show();
		$('#controlMembers').show();
		resultMembers = [];
		useMember = [];
		$('#members').html('');
		
	}

	function chooseMember(idMember){
		var data = getDataId(idMember, 'member');
		resultMembers = [];
		useMember = [];
		useMember.push(data);
		// 

		var idMember = data.id_member;
		var nameMember = data.name_member;
		var roleMember = data.role_member;
		var phoneMember = data.phone_member;

		var memberFrameUsage = 
			memberFrame[0]+idMember+ //id_member'
			memberFrame[1]+
			memberFrame[3]+
			memberFrame[4]+
			memberFrame[5]+idMember+ //id_member
			memberFrame[6]+
			memberFrame[7]+nameMember+//Name
			memberFrame[8]+
			memberFrame[9]+phoneMember+//Phone
			memberFrame[10]+
			memberFrame[11]+
			// memberFrame[12]+idMember+//id
			// memberFrame[13]+
			// memberFrame[14]+
			memberFrame[15];
			
		members = memberFrameUsage;
		var checkMember = $('#id_customer').text();
		if (checkMember == 'Customer') {
			$('#name_customer').text(nameMember);
		}else{			
			var user_cart = invoiceFrame[13]+nameMember+invoiceFrame[10];
			$('#user_cart').append(user_cart);
		}
		$('#members').html(members);
		// $('#controlMembers').hide();
	}

	function createMember(){
		var nameMember = $('#nameMember').val();
		var birthdayMember = $('#birthdayMember').val();
		var genderMember = $('#genderMember').val();
		var emailMember = $('#emailMember').val();
		var phoneMember = $('#phoneMember').val();
		var addressMember = $('#addressMember').val();

		if (nameMember != '' && birthdayMember != '' && genderMember != '' && emailMember != '' && phoneMember != '' && addressMember != '') {
			var accessMember = 'addMember';
			var accessUrl = base_url+'member/add';

			$.ajax({
				type: 'POST',
				url   : accessUrl,
				dataType : 'JSON',
				data :{
					nameMember : nameMember,
					birthdayMember : birthdayMember,
					genderMember : genderMember,
					emailMember : emailMember,
					phoneMember : phoneMember,
					addressMember : addressMember,
					accessMember : accessMember
				},
				success : function(data){
					if (data != false) {
						var members = '';

						resultMembers.push(data);
						for (var i = 0; i < data.length; i++) {
							var idMember = data[i].id_member;
							var nameMember = data[i].name_member;
							var roleMember = data[i].role_member;
							var phoneMember = data[i].phone_member;

							var memberFrameUsage = 
								memberFrame[0]+idMember+ //id_member'
								memberFrame[1]+
								memberFrame[3]+
								memberFrame[4]+
								memberFrame[5]+idMember+ //id_member
								memberFrame[6]+
								memberFrame[7]+nameMember+//Name
								memberFrame[8]+
								memberFrame[9]+phoneMember+//Phone
								memberFrame[10]+
								memberFrame[11]+
								memberFrame[12]+idMember+//id
								memberFrame[13]+
								memberFrame[14]+
								memberFrame[15];

							members += memberFrameUsage;
						}

						$('#members').html(members);
					}
				}
	 
			});
		}
	}

//---<> Member