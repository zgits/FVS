Package.describe({
  name: 'dangrossman:bootstrap-daterangepicker',
  version: '1.27',
  summary: 'Date range picker component for Bootstrap',
  git: 'https://github.com/dangrossman/bootstrap-daterangepicker',
  documentation: 'README.md'
});

Package.onUse(function(api) {
  api.versionsFrom('1');

  api.use('3.4', ["client"], {weak: true});
  api.use('3', ["client"]);
  api.use('jquery@1.11.3_2', ["client"]);

  api.addFiles('daterangepicker.js', ["client"]);
  api.addFiles('daterangepicker.css', ["client"]);
});
