/**
 * 
 */
$(function(){
	const $prodBuyer = $('[name="prodBuyer"]');
	$('[name="prodLgu"]').on("change", function(){
		let lgu = $(this).val();
		$prodBuyer.find(`option`).each(function(index, opt){
//			if(opt.classList.contains(lgu))
			if(index==0 || !lgu || ( lgu && $(opt).hasClass(lgu) )){
				$(opt).show();
			}else{
				$(opt).hide();
			}
		});
		$prodBuyer.find(`option:first`).prop(`selected`, true)
	})
	$(":input[data-init-value]").each(function(index, ipt){
		let initValue = $(ipt).data("initValue");
		$(ipt).val(initValue);
		$(ipt).trigger("change");
	});
	
});