$(document).ready(function () {
    $('#teachers .teachers-slider .item .rectangle').click(function () {
        $('#teachers .teachers-slider .item .rectangle').toggleClass('active');
    });

    $('#teachers .teachers-slider .slick-arrow').click(function () {
        $('#teachers .teachers-slider .item .rectangle').removeClass('active');
    });
});