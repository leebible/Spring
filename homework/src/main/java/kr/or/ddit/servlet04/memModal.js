document.addEventListener("DOMContentLoaded", function() {
    var modal = document.getElementById("myModal");
    var span = document.getElementsByClassName("close")[0];

    if (span) {
        span.onclick = function() {
            modal.style.display = "none";
        };
    }

    window.onclick = function(event) {
        if (event.target == modal) {
            modal.style.display = "none";
        }
    };

    var memberItems = document.querySelectorAll('.member-item');

    memberItems.forEach(function(memberItem) {
        memberItem.addEventListener('click', function() {
            var memberId = this.id;
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var modalContent = document.getElementById('memberDetailTable');
                        modalContent.innerHTML = xhr.responseText;
                        modal.style.display = "block";
                    } else {
                        console.error('Request failed: ' + xhr.status);
                    }
                }
            };
            xhr.open('GET', contextPath + '/people.do?memberId=' + memberId, true);
            xhr.send();
        });
    });
});
