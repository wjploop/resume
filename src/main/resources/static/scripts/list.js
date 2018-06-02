
let resume_ul;

$(function () {

    resume_ul = $('#resume-ul');

    loadResumes();

    $('#search_btn').on("click", searchResume);

    resume_ul.on('click', 'li', jumpDetail);

});



function loadResumes() {
    $.ajax({
        url: "resume/list",
        dataType: "json",
        type: "get",
        data:{},
        success: function (result) {
            let resumes = result.data;
            resume_ul.empty();
            $.each(resumes, function (index, resume) {
                let li = listItemTemplate.replace('[name]', resume.name);
                li = $(li).data('resume_id', resume.id);
                resume_ul.append(li);
            })
        },
        error: function () {
            resume_ul.append("请求失败");
        },

    })
}

function searchResume() {

    let keyword = $('#search_input').val().trim();

    console.log("search");
    $.ajax({
        url: "/resume/list",
        dataType: "json",
        type: "get",
        data: {"keyword": keyword},
        success: function (result) {
            let resumes = result.data;
            resume_ul.empty();
            if (resumes.length === 0) {
                resume_ul.append("没有找到相关简历");
                return;
            }
            $.each(resumes, function (index, resume) {
                let li = listItemTemplate.replace('[name]', resume.name);
                li = $(li).data('resume_id', resume.id);
                resume_ul.append(li);
            })
        },
        error: function () {
            resume_ul.append("请求失败");
        }

    });
}

function jumpDetail() {
    let resume_id = $(this).data('resume_id');
    window.location.href = "detail.html?resume_id=" + resume_id;
}

let listItemTemplate =
    '<li class="list-group-item resume-li">' +
    '[name]' +
    '</li>';


