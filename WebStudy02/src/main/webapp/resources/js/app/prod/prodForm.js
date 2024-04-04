/**
 * 
 */
$(function(){
   const $prodBuyer = $('[name="prodBuyer"]');
   $('[name="prodLgu"]').on("change", function(){
      let lgu = $(this).val();
      $prodBuyer.find(`option`).each(function(index, opt){
         //if(opt.classList.contains(lgu))
         if(index==0 || !lgu || (lgu && $(opt).hasClass(lgu))){
            $(opt).show();
         }else{
            $(opt).hide();
         }
      })
      $prodBuyer.find(`option:first`).prop(`selected`,true)
/*      if(lgu){
         $prodBuyer.find(`option`).hide();
         $prodBuyer.find(`option.${lgu}`).show();
      }else{
         $prodBuyer.find(`option`).show();
      }*/
   })
   $(":input[data-init-value]").each(function(index, ipt){
      let initValue = $(ipt).data("initValue");
      $(ipt).val(initValue);
      $(ipt).trigger("change");
   });
   
});








//오류났던 코드
//선택한 option 저장해놓기 위한. 데이터속성 이용하기.
$(function(){
	const $prodBuyer = $('[name="prodBuyer"]');
	$('[name="prodLgu"]').on("change",function(){
		let lgu = $(this).val();
		$prodBuyer.find(`option`).each(function(index, opt){//첫번째 propmt의 index가 왜 0?
//			if(opt.classList.contains(lgu))
//			index==0 ||
//			lgu 없는 경우 ||
			
			if(index==0 || !lgu ||$(opt).hasClass(lgu)){
				$(opt).show();
			}else{
				$(opt).hide();
			} 
		})
		$prodBuyer.find(`option:first`).prod(`selected`,true)
	})
	$(":input[data-init-value]").each(function(index, ipt){ //ipt : 입력태그 한개
		let initValue = $(ipt).data("initValue");
		$(ipt).val(initValue);
		$(ipt).trigger("change");
	});
	
		//위 코드로 변경
//		if(lgu){
//			$prodBuyer.find(`option`).hide();
//			$prodBuyer.find(`option.${lgu}`).show();
//		}else{
//			$prodBuyer.find(`option`).show();
//		}
});